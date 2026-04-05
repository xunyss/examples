package io.xunyss.examples;

import java.util.concurrent.locks.ReentrantLock;

public class LockTests {

    static void testLockInterruptible() {
        final ReentrantLock lock = new ReentrantLock();

        // 스레드 A: 락을 획득하고 아주 오래(무한히) 점유합니다.
        Thread threadA = new Thread(() -> {
            lock.lock();
            try {
                System.out.println("스레드 A: 락을 획득했습니다. 작업을 무한히 수행합니다...");
                while (true) {
                    Thread.sleep(1000); // 락을 놓지 않고 계속 잡고 있음
                }
            }
            catch (InterruptedException e) {
                System.out.println("스레드 A: 인터럽트 발생으로 종료합니다.");
            }
            finally {
                lock.unlock();
            }
        }, "Thread-A");

        // 스레드 B: 락을 획득하려고 대기하지만, 인터럽트가 가능하도록 설정합니다.
        Thread threadB = new Thread(() -> {
            try {
                System.out.println("스레드 B: 락 획득을 시도하며 대기합니다 (lockInterruptibly)...");
                // lock() 대신 lockInterruptibly()를 사용!
                lock.lockInterruptibly();
                try {
                    System.out.println("스레드 B: 드디어 락을 획득했습니다!");
                }
                finally {
                    lock.unlock();
                }
            }
            catch (InterruptedException e) {
                // 대기 중에 누군가 threadB.interrupt()를 호출하면 이쪽으로 옵니다.
                System.out.println("스레드 B: [알림] 락 대기 중 인터럽트가 발생하여 대기를 포기합니다.");
            }
        }, "Thread-B");

        threadA.start();

        try { Thread.sleep(500); } catch (InterruptedException e) {} // A가 먼저 잡도록 잠시 대기

        threadB.start();

        try { Thread.sleep(2000); } catch (InterruptedException e) {} // B가 대기하는 것을 확인하기 위해 대기

        // 메인 스레드에서 너무 오래 기다리는 B를 깨웁니다.
        System.out.println("메인 스레드: 스레드 B가 너무 오래 기다리니 인터럽트를 걸겠습니다.");
        threadB.interrupt();
    }

    public static void main(String[] args) {
        testLockInterruptible();
    }
}

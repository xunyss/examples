package io.xunyss.examples;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class LockComparison {

    private final ReentrantLock reentrantLock = new ReentrantLock();
    private final Object syncLock = new Object();

    // 1. synchronized를 이용한 동기화
    public void synchronizedMethod(String threadName) {
        synchronized (syncLock) {
            try {
                System.out.println(threadName + " - synchronized 락 획득!");
                Thread.sleep(1000); // 작업 중...
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            finally {
                System.out.println(threadName + " - synchronized 락 해제");
            }
        }
    }

    // 2. ReentrantLock을 이용한 동기화
    public void reentrantLockMethod(String threadName) {
        reentrantLock.lock(); // 락 획득 시도 (획득할 때까지 대기)
        try {
            System.out.println(threadName + " - ReentrantLock 획득!");
            Thread.sleep(1000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            // 반드시 finally 블록에서 해제해야 함
            reentrantLock.unlock();
            System.out.println(threadName + " - ReentrantLock 해제");
        }
    }

    // 3. ReentrantLock만의 장점: tryLock (기다리지 않고 시도해보기)
    public void tryLockMethod(String threadName) {
        try {
            // 2초 동안만 기다려보고 안되면 포기! (synchronized는 포기가 불가능함)
            if (reentrantLock.tryLock(2, TimeUnit.SECONDS)) {
                try {
                    System.out.println(threadName + " - tryLock 성공!");
                    Thread.sleep(3000); // 3초 소요
                }
                finally {
                    reentrantLock.unlock();
                    System.out.println(threadName + " - tryLock 해제");
                }
            }
            else {
                System.out.println(threadName + " - 락 획득 실패 (너무 오래 기다려서 포기)");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        LockComparison example = new LockComparison();

        System.out.println("=== 1. ReentrantLock의 tryLock 테스트 ===");
        Thread t1 = new Thread(() -> example.synchronizedMethod("Thread-1"));
        Thread t2 = new Thread(() -> example.synchronizedMethod("Thread-2"));

        t1.start();
        Thread.sleep(100); // Thread-1이 먼저 점유하도록 약간 대기
        t2.start();

        t1.join();
        t2.join();
    }
}
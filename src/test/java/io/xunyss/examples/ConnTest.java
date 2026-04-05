package io.xunyss.examples;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConnTest {

    public static void main(String[] args) {
        Queue<String> q = new ConcurrentLinkedQueue<>();

        ExecutorService executor = Executors.newFixedThreadPool(6);
    }
}

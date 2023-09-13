package com.juc.future;

import java.util.concurrent.*;

/**
 * @author Wu.Chunyang
 */
public class CompletableFutureDemo1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
        ExecutorService executor = Executors.newFixedThreadPool(2);
        asyncTask1(executor);
        // task1();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    private static void task1() {
        run1("task 1");
        run1("task 2");
        run1("task 3");
    }

    private static void asyncTask1(ExecutorService executor) throws InterruptedException, ExecutionException {
        CompletableFuture<Void> future1 = CompletableFuture.runAsync(() -> run1("task 1"), executor);
        CompletableFuture<Void> future2 = CompletableFuture.runAsync(() -> run1("task 2"), executor);
        CompletableFuture<Void> future3 = CompletableFuture.runAsync(() -> run1("task 3"), executor);
        future1.get();
        future2.get();
        future3.get();
    }

    private static void run1(String x) {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(x);
    }
}

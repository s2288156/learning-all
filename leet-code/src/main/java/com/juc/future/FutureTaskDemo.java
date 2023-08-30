package com.juc.future;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * @author Wu.Chunyang
 */
@Slf4j
public class FutureTaskDemo {
    static ExecutorService executors = Executors.newFixedThreadPool(3);

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        // main1();
        main2();
        long end = System.currentTimeMillis();
        log.info("run time: {} ms", end - start);
    }

    private static void main2() {
        FutureTask<String> task1 = futureTask("task1", 300);
        executors.submit(task1);
        FutureTask<String> task2 = futureTask("task2", 400);
        executors.submit(task2);
        FutureTask<String> task3 = futureTask("task3", 500);
        executors.submit(task3);
        try {
            log.info("{}, {}, {}", task1.get(), task2.get(), task3.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    private static void main1() {
        task("task1", 300);
        task("task2", 400);
        task("task3", 500);
    }

    private static String task(String name, long sleepTimeout) {
        try {
            TimeUnit.MILLISECONDS.sleep(sleepTimeout);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return name + " finished.";
    }

    private static FutureTask<String> futureTask(String name, long sleepTimeout) {
        return new FutureTask<String>(() -> task(name, sleepTimeout));
    }
}

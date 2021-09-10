package com.jdk.future;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author wuyang
 */
@Slf4j
@SuppressWarnings("ALL")
public class FutureMain {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> submit = executorService.submit(() ->{
            log.info("start: {}", System.currentTimeMillis());
            Thread.sleep(3000);
            log.info("end: {}", System.currentTimeMillis());
            return "hello";
        });

        log.info("waiting future");
        log.info("get = {}", submit.get());
        executorService.shutdownNow();
    }
}

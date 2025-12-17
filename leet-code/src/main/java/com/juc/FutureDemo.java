package com.juc;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;

import java.util.concurrent.*;

/**
 * @author Wu.Chunyang
 */
@Slf4j
public class FutureDemo {
    private static ExecutorService executor = new ThreadPoolExecutor(0,
            10, 60L, TimeUnit.SECONDS, new SynchronousQueue<>(),new ThreadPoolExecutor.CallerRunsPolicy());


    public static void main(String[] args) throws ExecutionException, InterruptedException {

        for (int i = 0; i < 100; i++) {
            fun1(i);
        }

        log.info("主线程继续执行...");
        try {
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static void fun1(int id) {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            log.info("task [{}] start...", id);
            int timeout = RandomUtils.nextInt(3000, 5000);
            return process(timeout);
        }, executor);

        // 异步回调：任务完成后自动处理结果（不阻塞主线程）
        future.thenAccept(result -> {
            log.info("任务[{}]获取结果: {}", id, result);
        });
    }

    private static String process(int timeout) {
        try {
            Thread.sleep(timeout); // 模拟耗时任务
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return "任务执行时间: " + timeout + "ms";
    }
}

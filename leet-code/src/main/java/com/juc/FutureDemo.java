package com.juc;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Wu.Chunyang
 */
@Slf4j
public class FutureDemo {
    private static ExecutorService executor = Executors.newFixedThreadPool(4);
    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {
            task(i);
        }

        log.info("主线程继续执行...");
        try {
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static void task(int id) {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            log.info("task [{}] start...", id);
            int timeout = RandomUtils.nextInt(3000, 5000);
            process(timeout);
            return "任务执行时间: " + timeout + "ms";
        }, executor);

        // 异步回调：任务完成后自动处理结果（不阻塞主线程）
        future.thenAccept(result -> {
            log.info("任务[{}]获取结果: {}", id, result);
        });
    }

    private static void process(int timeout) {
        try {
            Thread.sleep(timeout); // 模拟耗时任务
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

package com.demo.controller;

import com.demo.thread.DeadLockThread;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author WuChunYang
 */
@Slf4j
@RequestMapping("/thread")
@RestController
public class ThreadPoolController {
    ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
            4,
            10,
            0,
            TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(1024),
            Executors.defaultThreadFactory(),
            new ThreadPoolExecutor.AbortPolicy()
    );

    @GetMapping("/pool/dead_lock")
    public String deadLock() {
        Object lock1 = new Object();
        Object lock2 = new Object();
        threadPool.submit(new DeadLockThread(lock1, lock2), "deadLockThread-" + new Random().nextInt());
        threadPool.submit(new DeadLockThread(lock2, lock1), "deadLockThread-" + new Random().nextInt());
        return "ok";
    }

    @GetMapping("/pool/info")
    public Map<String, Object> threadPoolInfo() {
        Map<String, Object> response = new HashMap<>();

        return response;
    }
}

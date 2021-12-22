package com.demo.controller;

import com.demo.thread.DeadLockThread;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.*;

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
            new LinkedBlockingQueue<>(16),
            Executors.defaultThreadFactory(),
            new ThreadPoolExecutor.AbortPolicy()
    );

    ThreadPoolExecutor fixThreadPool = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);

    @GetMapping("/fix_pool/dead_lock")
    public String fixPoolDeadLock() {
        Object lock1 = new Object();
        Object lock2 = new Object();
        fixThreadPool.submit(new DeadLockThread(lock1, lock2), "deadLockThread-" + new Random().nextInt());
        fixThreadPool.submit(new DeadLockThread(lock2, lock1), "deadLockThread-" + new Random().nextInt());
        return "ok";
    }

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

        Map<String, Object> pollInfo = new HashMap<>();
        Map<String, Object> fixPollInfo = new HashMap<>();

        pollInfo.put("corePoolSize", threadPool.getCorePoolSize());
        pollInfo.put("poolSize", threadPool.getPoolSize());
        pollInfo.put("maximumPoolSize", threadPool.getMaximumPoolSize());
        pollInfo.put("queueSize", threadPool.getQueue().size());

        fixPollInfo.put("corePoolSize", fixThreadPool.getCorePoolSize());
        fixPollInfo.put("poolSize", fixThreadPool.getPoolSize());
        fixPollInfo.put("maximumPoolSize", fixThreadPool.getMaximumPoolSize());
        fixPollInfo.put("queueSize", fixThreadPool.getQueue().size());

        response.put("pollInfo", pollInfo);
        response.put("fixPollInfo", fixPollInfo);
        return response;
    }
}

package com.demo.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * @author WuChunYang
 */
@Slf4j
public class DeadLockThread implements Runnable {
    private Object lock1;

    private Object lock2;

    public DeadLockThread(Object lock1, Object lock2) {
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    @Override
    public void run() {
        synchronized (lock2) {
            log.info("{} get lock2 and wait lock1", Thread.currentThread().getName());
            try {
                TimeUnit.MILLISECONDS.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lock1) {
                log.info("{} get lock1 and lock2", Thread.currentThread().getName());
            }
        }
    }
}

package com.juc.lock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Wu.Chunyang
 */
@Slf4j
public class ReentrantLockDemo {
    private static final Object lock = new Object();
    private static final ReentrantLock reentrantLock = new ReentrantLock();

    public static void main(String[] args) {
        // syncReLock();
        reentrantLockTest();

        log.info("all lock was unlocked.");
    }

    private static void reentrantLockTest() {
        reentrantLock.lock();
        log.info("{} locked {} times", Thread.currentThread().getName(), 1);
        reentrantLock.lock();
        log.info("{} locked {} times", Thread.currentThread().getName(), 2);
        reentrantLock.lock();
        log.info("{} locked {} times", Thread.currentThread().getName(), 3);
        while (reentrantLock.isLocked()) {
            log.info("reentrantLock hold count: {}", reentrantLock.getHoldCount());
            reentrantLock.unlock();
        }
        log.info("reentrantLock.isLocked() = {}", reentrantLock.isLocked());
    }

    /**
     * synchronized关键字默认实现为可重入锁
     */
    private static void syncReLock() {
        synchronized (lock) {
            log.info("lock 1 in ...");
            synchronized (lock) {
                log.info("lock 2 in ...");
                synchronized (lock) {
                    log.info("lock 3 in ...");
                }
            }
        }
    }
}

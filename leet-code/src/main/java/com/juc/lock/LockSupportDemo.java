package com.juc.lock;

import com.juc.BaseDemo;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Wu.Chunyang
 */
@Slf4j
public class LockSupportDemo extends BaseDemo {
    public static void main(String[] args) {
        // 使用wait() notify()必须在同步代码块中调用，否则会抛异常
        // error_must_has_lock();
        // wait_notify();

        // 使用 await() signal()必须在Lock.lock()后调用，否则会抛出异常
        // lock_condition_await_signal();

        lockSupport();
    }

    private static void lockSupport() {
        Thread t1 = new Thread(() -> {
            log.info("{} \t come in.", Thread.currentThread().getName());
            LockSupport.park();
            log.info("{} \t unlocked.", Thread.currentThread().getName());
        }, "t1");
        t1.start();

        sleepSec(1);

        new Thread(() -> {
            LockSupport.unpark(t1);
            log.info("{} \t unpark t1.", Thread.currentThread().getName());
        }, "t2").start();
    }

    private static void lock_condition_await_signal() {
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        new Thread(() -> {
            log.info("{} \t come in.", Thread.currentThread().getName());
            lock.lock();
            try {
                condition.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            lock.unlock();
            log.info("{} \t unlocked.", Thread.currentThread().getName());
        }, "t1").start();

        sleepSec(1);

        new Thread(() -> {
            lock.lock();
            condition.signal();
            lock.unlock();
            log.info("{} \t signal t1.", Thread.currentThread().getName());
        }, "t2").start();
    }


    private static void wait_notify() {
        Object lock = new Object();
        new Thread(() -> {
            log.info("{} \t come in.", Thread.currentThread().getName());
            synchronized (lock) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            log.info("{} \t unlocked.", Thread.currentThread().getName());
        }, "t1").start();

        sleepSec(1);

        new Thread(() -> {
            synchronized (lock) {
                lock.notify();
            }
            log.info("{} \t notify.", Thread.currentThread().getName());
        }, "t2").start();
    }

    private static void error_must_has_lock() {
        Object lock = new Object();
        new Thread(() -> {
            log.info("{} \t come in.", Thread.currentThread().getName());
            try {
                lock.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            log.info("{} \t unlocked.", Thread.currentThread().getName());
        }, "t1").start();

        sleepSec(1);

        new Thread(() -> {
            lock.notify();
            log.info("{} \t notify.", Thread.currentThread().getName());
        }, "t2").start();
    }
}

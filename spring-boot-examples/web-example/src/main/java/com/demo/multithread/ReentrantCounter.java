package com.demo.multithread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wuyang
 */
public class ReentrantCounter {
    private final Lock lock = new ReentrantLock();

    private int count;

    private void add(int n) {
//        lock.lock();
        if (lock.tryLock()) {
            try {
                count += n;
            } finally {
                lock.unlock();
            }
        }
    }
}

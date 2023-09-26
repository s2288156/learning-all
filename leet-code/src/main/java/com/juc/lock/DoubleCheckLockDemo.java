package com.juc.lock;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author Wu.Chunyang
 */
public class DoubleCheckLockDemo {
    private static DoubleCheckLockDemo singleton;

    private DoubleCheckLockDemo() {
    }

    public static DoubleCheckLockDemo newInstance() {
        if (singleton == null) {
            synchronized (DoubleCheckLockDemo.class) {
                if (singleton == null) {
                    singleton = new DoubleCheckLockDemo();
                }
            }
        }
        return singleton;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100000; i++) {
            new Thread(() -> {
                try {
                    TimeUnit.MILLISECONDS.sleep(new Random().nextLong(1, 10));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                DoubleCheckLockDemo.newInstance();
            }).start();
        }
    }
}

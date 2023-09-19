package com.juc.clock;

/**
 * @author Wu.Chunyang
 */
public class ReentrantLockDemo {
    public static void main(String[] args) {
        syncReLock();
    }

    private static final Object lock = new Object();

    private static void syncReLock() {
        synchronized (lock) {
            System.out.println("lock 1 in ...");
            synchronized (lock) {
                System.out.println("lock 2 in ...");
                synchronized (lock) {
                    System.out.println("lock 3 in ...");
                }
            }
        }
        System.out.println("all lock was unlocked.");
    }
}

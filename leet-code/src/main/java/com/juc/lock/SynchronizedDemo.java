package com.juc.lock;

/**
 * @author Wu.Chunyang
 */
public class SynchronizedDemo {

    private final Object object = new Object();

    public void syncCodeBock() {
        synchronized (object) {
            System.out.println("hello ----------------------");
        }
    }

    public synchronized void syncMethod() {
        System.out.println("sync method ---------------------");
    }

    public static synchronized void syncStaticMethod() {
        System.out.println("sync static method --------------");
    }

}

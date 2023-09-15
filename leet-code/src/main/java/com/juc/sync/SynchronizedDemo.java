package com.juc.sync;

/**
 * @author Wu.Chunyang
 */
public class SynchronizedDemo {

    private Object object = new Object();

    public void syncCodeBock() {
        synchronized (object) {
            System.out.println("hello ----------------------");
        }
    }

    
}

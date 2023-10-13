package com.juc;

import java.util.concurrent.TimeUnit;

/**
 * @author Wu.Chunyang
 */
public abstract class BaseJuc {

    public static void sleepSec(int n) {
        try {
            TimeUnit.SECONDS.sleep(n);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

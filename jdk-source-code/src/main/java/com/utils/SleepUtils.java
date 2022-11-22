package com.utils;

import java.util.concurrent.TimeUnit;

public class SleepUtils {
    public static void sleepSec(long sec) {
        try {
            TimeUnit.SECONDS.sleep(sec);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

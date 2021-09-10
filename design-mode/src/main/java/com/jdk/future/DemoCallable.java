package com.jdk.future;

import java.util.concurrent.*;

/**
 * @author wuyang
 */
public class DemoCallable implements Callable<String> {

    @Override
    public String call() throws Exception {
        return "DemoCallable";
    }
}

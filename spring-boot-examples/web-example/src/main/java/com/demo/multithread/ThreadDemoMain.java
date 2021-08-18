package com.demo.multithread;

/**
 * @author wuyang
 */
public class ThreadDemoMain {
    public static void main(String[] args) {
        ThreadDemoMain main = new ThreadDemoMain();
        main.useYield();
    }

    private void useYield() {
        Runnable runnable = () -> {
            for (int i = 0; i < 51; i++) {
                System.out.println(Thread.currentThread().getName() + "------" + i);
            }
        };
        Runnable yield = () -> {
            for (int i = 0; i < 51; i++) {
                if (i % 10 == 0) {
                    Thread.yield();
                }
                System.out.println(Thread.currentThread().getName() + "------" + i);
            }
        };

        new Thread(runnable, "老王").start();
        new Thread(yield, "小张@@@@@@@").start();
    }
}

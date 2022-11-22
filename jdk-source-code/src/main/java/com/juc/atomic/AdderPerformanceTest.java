package com.juc.atomic;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.concurrent.atomic.LongAdder;

class Number {
    long num = 0;

    public synchronized void syncIncrement() {
        num++;
    }

    AtomicLong atomicNum = new AtomicLong(0);

    public void atomicIncrement() {
        atomicNum.incrementAndGet();
    }

    LongAdder adderNum = new LongAdder();

    public void adderIncrement() {
        adderNum.increment();
    }

    LongAccumulator accumulatorNum = new LongAccumulator(Long::sum, 0);

}

@Slf4j
public class AdderPerformanceTest {
    public static final int _1000W = 1000 * 10000;
    public static final int _thread_count = 50;

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch1 = new CountDownLatch(_thread_count);
        CountDownLatch countDownLatch2 = new CountDownLatch(_thread_count);
        CountDownLatch countDownLatch3 = new CountDownLatch(_thread_count);
        CountDownLatch countDownLatch4 = new CountDownLatch(_thread_count);
        long start;
        long end;
        Number number = new Number();

        start = System.currentTimeMillis();
        for (int i = 0; i < _thread_count; i++) {
            new Thread(() -> {
                for (int j = 0; j < _1000W; j++) {
                    number.syncIncrement();
                }
                countDownLatch1.countDown();
            }).start();
        }
        countDownLatch1.await();
        end = System.currentTimeMillis();
        log.info("[syncIncrement] \t result = {}, 耗时: {}ms", number.num, end - start);



        start = System.currentTimeMillis();
        for (int i = 0; i < _thread_count; i++) {
            new Thread(() -> {
                for (int j = 0; j < _1000W; j++) {
                    number.atomicIncrement();
                }
                countDownLatch2.countDown();
            }).start();
        }
        countDownLatch2.await();
        end = System.currentTimeMillis();
        log.info("[atomicIncrement] \t result = {}, 耗时: {}ms", number.atomicNum.get(), end - start);


        start = System.currentTimeMillis();
        for (int i = 0; i < _thread_count; i++) {
            new Thread(() -> {
                for (int j = 0; j < _1000W; j++) {
                    number.adderIncrement();
                }
                countDownLatch3.countDown();
            }).start();
        }
        countDownLatch3.await();
        end = System.currentTimeMillis();
        log.info("[adderIncrement] \t result = {}, 耗时: {}ms", number.adderNum.sum(), end - start);


        start = System.currentTimeMillis();
        for (int i = 0; i < _thread_count; i++) {
            new Thread(() -> {
                for (int j = 0; j < _1000W; j++) {
                    number.accumulatorNum.accumulate(1);
                }
                countDownLatch4.countDown();
            }).start();
        }
        countDownLatch4.await();
        end = System.currentTimeMillis();
        log.info("[accumulate] \t result = {}, 耗时: {}ms", number.accumulatorNum.get(), end - start);
    }
}

package com.juc.atomic;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.concurrent.atomic.LongAdder;

/**
 * @author Wu.Chunyang
 */
@Slf4j
public class PerformanceTestPlus {
    private static int num = 0;

    private synchronized static void addNum() {
        num++;
    }

    private static AtomicLong atomicNum = new AtomicLong();

    private static LongAdder adderNum = new LongAdder();

    private static LongAccumulator accumulatorNum = new LongAccumulator((Long::sum), 0);

    @SneakyThrows
    public static void main(String[] args) {
        int threadNum = 50;
        int _10000k = 10000000;
        long start, end;
        CountDownLatch countDownLatch1 = new CountDownLatch(threadNum);
        start = System.currentTimeMillis();
        for (int i = 0; i < threadNum; i++) {
            new Thread(() -> {
                for (int j = 0; j < _10000k; j++) {
                    addNum();
                }
                countDownLatch1.countDown();
            }).start();
        }
        countDownLatch1.await();
        end = System.currentTimeMillis();
        log.info("addNum: \t\t\t{} ms, result = {}", end - start, num);

        CountDownLatch countDownLatch2 = new CountDownLatch(threadNum);
        start = System.currentTimeMillis();
        for (int i = 0; i < threadNum; i++) {
            new Thread(() -> {
                for (int j = 0; j < _10000k; j++) {
                    atomicNum.incrementAndGet();
                }
                countDownLatch2.countDown();
            }).start();
        }
        countDownLatch2.await();
        end = System.currentTimeMillis();
        log.info("atomicNum: \t\t{} ms, result = {}", end - start, atomicNum.get());

        CountDownLatch countDownLatch3 = new CountDownLatch(threadNum);
        start = System.currentTimeMillis();
        for (int i = 0; i < threadNum; i++) {
            new Thread(() -> {
                for (int j = 0; j < _10000k; j++) {
                    adderNum.increment();
                }
                countDownLatch3.countDown();
            }).start();
        }
        countDownLatch3.await();
        end = System.currentTimeMillis();
        log.info("adderNum: \t\t{} ms, result = {}", end - start, adderNum.sum());

        CountDownLatch countDownLatch4 = new CountDownLatch(threadNum);
        start = System.currentTimeMillis();
        for (int i = 0; i < threadNum; i++) {
            new Thread(() -> {
                for (int j = 0; j < _10000k; j++) {
                    accumulatorNum.accumulate(1);
                }
                countDownLatch4.countDown();
            }).start();
        }
        countDownLatch4.await();
        end = System.currentTimeMillis();
        log.info("accumulatorNum: \t{} ms, result = {}", end - start, accumulatorNum.get());
    }
}

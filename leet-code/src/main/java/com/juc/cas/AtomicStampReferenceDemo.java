package com.juc.cas;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author Wu.Chunyang
 */
@Slf4j
public class AtomicStampReferenceDemo {
    /**
     * 1. 线程t1获取stamp初始值 == 1, 休眠100ms保证线程t2获取到相同的stamp == 1
     * 2. 线程t1将reference从zhangsan设置为lisi后，再将lisi设置成zhangsan，复现ABA场景，此时stamp+1两次，stamp == 3
     * 3. 线程t2将zhangsan设置为lisi，因为stamp已经变化，所以result == false
     */
    public static void main(String[] args) {
        User zhangSan = new User("zhang san", 10);
        User liSi = new User("li si", 20);
        AtomicStampedReference<User> atomicUser = new AtomicStampedReference<>(zhangSan, 1);
        new Thread(() -> {
            int stamp = atomicUser.getStamp();
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            log.info("{} \t {}", atomicUser.compareAndSet(zhangSan, liSi, stamp, stamp + 1), atomicUser.getReference());
            log.info("{} \t {}", atomicUser.compareAndSet(liSi, zhangSan, atomicUser.getStamp(), atomicUser.getStamp() + 1), atomicUser.getReference());
        }, "t1").start();

        new Thread(() -> {
            int stamp = atomicUser.getStamp();
            try {
                TimeUnit.MILLISECONDS.sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            log.info("{} \t {}", atomicUser.compareAndSet(zhangSan, liSi, stamp, stamp + 1), atomicUser.getReference());
        }, "t2").start();
    }
}

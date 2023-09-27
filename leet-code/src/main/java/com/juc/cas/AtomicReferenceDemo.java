package com.juc.cas;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author Wu.Chunyang
 */
@Slf4j
public class AtomicReferenceDemo {
    public static void main(String[] args) {
        User zhangSan = new User("zhang san", 30);
        User zhangSan1 = new User("zhang san", 30);
        User liSi = new User("li si", 22);

        AtomicReference<User> user = new AtomicReference<>();

        user.compareAndSet(null, zhangSan);
        log.info("ref {}", user.get());
        // user.get().setAge(19);
        log.info("zhangSan {}, zhangSan1 {}", zhangSan, zhangSan1);
        log.info("zhangSan.equals(zhangSan1) = {}", zhangSan.equals(zhangSan1));
        log.info("zhangSan == zhangSan1: {}", zhangSan == zhangSan1);
        user.compareAndSet(zhangSan1, liSi);
        log.info("{} , {}", user.compareAndSet(zhangSan1, liSi), user.get());
    }
}


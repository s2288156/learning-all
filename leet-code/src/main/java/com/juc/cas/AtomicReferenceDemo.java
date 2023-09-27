package com.juc.cas;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author Wu.Chunyang
 */
@Slf4j
public class AtomicReferenceDemo {
    public static void main(String[] args) {
        User zhangSan = new User("zhang san", 30);
        User liSi = new User("li si", 22);

        AtomicReference<User> user = new AtomicReference<>();

        user.compareAndSet(null, zhangSan);
        log.info("{}", user.get());
        user.get().setAge(19);
        log.info("{}", zhangSan);
        user.compareAndSet(zhangSan, liSi);
        log.info("{}", user.get());
    }
}

@AllArgsConstructor
@Data
class User {

    private String name;

    private Integer age;

}

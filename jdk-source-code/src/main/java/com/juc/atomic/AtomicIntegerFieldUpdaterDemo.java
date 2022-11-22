package com.juc.atomic;

import com.utils.SleepUtils;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

@Slf4j
public class AtomicIntegerFieldUpdaterDemo {
    public static void main(String[] args) {
        Account account = new Account();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    // account.increment();
                    account.atomicIncrement();
                }
            }, "t" + i).start();
        }

        SleepUtils.sleepSec(2);
        log.info("{}", account);
    }
}

@Data
class Account {
    private String name;
    private volatile int total;

    public Account() {
        this.name = "aka";
        this.total = 0;
    }

    // public synchronized void increment() {
    //     total++;
    // }

    AtomicIntegerFieldUpdater<Account> fieldUpdater = AtomicIntegerFieldUpdater.newUpdater(Account.class, "total");

    public void atomicIncrement() {
        fieldUpdater.incrementAndGet(this);
    }
}

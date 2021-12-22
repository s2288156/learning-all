package com.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author WuChunYang
 */
@Slf4j
@RequestMapping("/jvm")
@RestController
public class JvmController {

    @GetMapping("/cpu/loop")
    public void testCpuLoop() {
        log.warn("请求cpu死循环");
        Thread.currentThread().setName("loop-thread-cpu");
        int num = 0;
        while (true) {
            num++;
            if (num == Integer.MAX_VALUE) {
                log.warn("reset num: {}", num);
                num = 0;
            }
        }
    }

    @GetMapping("/memory/leak")
    public String memLeak() {
        log.warn("模拟内存泄漏");
        ThreadLocal<Byte[]> local = new ThreadLocal<>();
        // 1024 byte = 1kb, 1024 kb = 1 MB
        local.set(new Byte[4 * 1024 * 1024]);
        return "ok";
    }
}

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
                log.warn("reset num: ", num);
                num = 0;
            }
        }
    }
}

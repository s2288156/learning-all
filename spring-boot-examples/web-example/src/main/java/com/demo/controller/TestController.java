package com.demo.controller;

import com.demo.service.IServiceA;
import com.demo.service.IServiceB;
import com.demo.vo.SingleResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author wuyang
 */
@Slf4j
@RestController
public class TestController {

    @Autowired
    private IServiceA serviceA;

    @Autowired
    private IServiceB serviceB;

    @GetMapping("/request")
    public SingleResponse req() {
        log.info("request start");
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return SingleResponse.success();
    }

    @GetMapping("/request/delay")
    public SingleResponse reqDelay() {
        log.info("request delay start");
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
        log.info("request delay end");
        return SingleResponse.success();
    }

    @GetMapping("/service/a")
    public String serviceA() {
        log.info("serviceA");
        return serviceA.saySelf();
    }

    @GetMapping("/service/b")
    public String serviceB() {
        return serviceB.saySelf();
    }
}

package com.demo.controller;

import com.demo.service.IServiceA;
import com.demo.service.IServiceB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wuyang
 */
@RestController
public class TestController {

    @Autowired
    private IServiceA serviceA;

    @Autowired
    private IServiceB serviceB;

    @GetMapping("/service/a")
    public String serviceA() {
        return serviceA.saySelf();
    }

    @GetMapping("/service/b")
    public String serviceB() {
        return serviceB.saySelf();
    }
}

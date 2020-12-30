package com.example.consumer.controller;

import com.example.provider.api.ProviderApi;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wcy
 */
@RestController
public class ConsumerController {

    @DubboReference(check = false)
    private ProviderApi providerApi;

    @GetMapping("/say")
    public String say() {
        return providerApi.sayHello("consumer web invoke");
    }
}

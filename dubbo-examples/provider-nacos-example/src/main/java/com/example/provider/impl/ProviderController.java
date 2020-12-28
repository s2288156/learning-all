package com.example.provider.impl;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wcy
 */
@RestController
public class ProviderController {

    @GetMapping("/say")
    public String say() {
        return "this is provider controller";
    }
}

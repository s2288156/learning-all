package com.example.provider.impl;

import com.example.provider.api.ProviderApi;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * @author wcy
 */
@DubboService
public class ProviderApiImpl implements ProviderApi {
    @Override
    public String sayHello(String msg) {
        return "provider say: " + msg;
    }
}

package com.demo.service.impl;

import com.demo.service.IServiceA;
import com.demo.service.IServiceB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wuyang
 */
@Service
public class ServiceBImpl implements IServiceB {

    @Autowired
    private IServiceA serviceA;

    @Override
    public String saySelf() {
        return null;
    }
}

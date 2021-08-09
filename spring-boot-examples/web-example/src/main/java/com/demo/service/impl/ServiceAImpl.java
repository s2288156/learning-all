package com.demo.service.impl;

import com.demo.service.IServiceA;
import com.demo.service.IServiceB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wuyang
 */
@Service
public class ServiceAImpl implements IServiceA {

    @Autowired
    private IServiceB serviceB;

    @Override
    public String saySelf() {
        return "serviceA sayed: >>> ";
    }
}

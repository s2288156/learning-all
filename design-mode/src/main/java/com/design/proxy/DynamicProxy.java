package com.design.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author wuyang
 */
public class DynamicProxy implements InvocationHandler {

    private final Object target;

    public DynamicProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before dynamic proxy");
        Object result = method.invoke(target, args);
        System.out.println("after dynamic proxy");
        return result;
    }
}

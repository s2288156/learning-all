package com.design.proxy;

import java.lang.reflect.Proxy;

/**
 * @author wuyang
 */
public class JdkDynamicProxyFactory {
    public static Object getProxy(Object target) {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new DynamicProxy(target));
    }
}

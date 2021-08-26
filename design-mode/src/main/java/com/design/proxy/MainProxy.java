package com.design.proxy;

/**
 * @author wuyang
 */
public class MainProxy {
    public static void main(String[] args) {
        StaticSmsProxy smsProxy = new StaticSmsProxy(new SmsServiceImp());
        smsProxy.send("hello");

        ISmsService proxy = (ISmsService) JdkDynamicProxyFactory.getProxy(new SmsServiceImp());
        proxy.send("good");
    }
}

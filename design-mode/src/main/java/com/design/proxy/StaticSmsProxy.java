package com.design.proxy;

/**
 * @author wuyang
 */
public class StaticSmsProxy implements ISmsService{

    private ISmsService smsService;

    public StaticSmsProxy(ISmsService smsService) {
        this.smsService = smsService;
    }

    @Override
    public String send(String msg) {
        System.out.println("before method send");
        smsService.send(msg);
        System.out.println("after method send");
        return null;
    }
}

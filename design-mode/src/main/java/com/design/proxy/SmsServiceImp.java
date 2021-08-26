package com.design.proxy;

/**
 * @author wuyang
 */
public class SmsServiceImp implements ISmsService{
    @Override
    public String send(String msg) {
        System.out.println("SmsService sendMsg: " + msg);
        return msg;
    }
}

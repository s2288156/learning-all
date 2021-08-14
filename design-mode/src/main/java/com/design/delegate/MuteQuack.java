package com.design.delegate;

/**
 * @author wuyang
 */
public class MuteQuack implements QuackBehavior{
    @Override
    public void quack() {
        System.out.println(".............................");
    }
}

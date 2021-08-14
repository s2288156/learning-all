package com.design.strategy.duck;

/**
 * @author wuyang
 */
public class MuteQuack implements QuackBehavior{
    @Override
    public void quack() {
        System.out.println(".............................");
    }
}

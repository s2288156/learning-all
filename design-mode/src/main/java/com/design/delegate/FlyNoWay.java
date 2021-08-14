package com.design.delegate;

/**
 * @author wuyang
 */
public class FlyNoWay implements FlyBehavior{
    @Override
    public void fly() {
        System.out.println("飞是不可能飞了，这被子也不可能飞！别的又不会...");
    }
}

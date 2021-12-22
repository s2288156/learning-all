package com.design.strategy.duck;

/**
 * @author wuyang
 */
public class FlyWithWings implements FlyBehavior{
    @Override
    public void fly() {
        System.out.println("我真会飞！");
    }
}
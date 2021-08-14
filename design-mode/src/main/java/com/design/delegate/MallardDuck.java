package com.design.delegate;

/**
 * @author wuyang
 */
public class MallardDuck extends Duck{
    public MallardDuck() {
        flyBehavior = new FlyWithWings();
        quackBehavior = new Quack();
    }

    @Override
    public void display() {
        System.out.println("我是野鸭");
    }
}

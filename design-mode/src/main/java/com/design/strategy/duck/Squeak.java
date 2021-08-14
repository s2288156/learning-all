package com.design.strategy.duck;

/**
 * @author wuyang
 */
public class Squeak implements QuackBehavior{
    @Override
    public void quack() {
        System.out.println("Squeak!!!");
    }
}

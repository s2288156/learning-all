package com.design.delegate;

/**
 * @author wuyang
 */
public class Squeak implements QuackBehavior{
    @Override
    public void quack() {
        System.out.println("Squeak!!!");
    }
}

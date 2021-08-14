package com.design.delegate;

/**
 * @author wuyang
 */
public class Quack implements QuackBehavior{
    @Override
    public void quack() {
        System.out.println("嘎嘎嘎！");
    }
}

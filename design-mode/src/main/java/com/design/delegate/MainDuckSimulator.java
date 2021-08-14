package com.design.delegate;

/**
 * @author wuyang
 */
public class MainDuckSimulator {
    public static void main(String[] args) {
        Duck duck = new MallardDuck();
        duck.performFly();
        duck.performQuack();
    }
}

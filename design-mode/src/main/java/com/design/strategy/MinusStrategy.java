package com.design.strategy;

/**
 * @author wuyang
 */
public class MinusStrategy implements Strategy{
    @Override
    public int operation(int a, int b) {
        return a - b;
    }
}

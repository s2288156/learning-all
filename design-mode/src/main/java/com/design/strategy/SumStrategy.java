package com.design.strategy;

/**
 * @author wuyang
 */
public class SumStrategy implements Strategy{
    @Override
    public int operation(int a, int b) {
        return a + b;
    }
}

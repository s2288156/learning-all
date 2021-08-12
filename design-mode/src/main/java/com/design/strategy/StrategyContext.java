package com.design.strategy;

/**
 * @author wuyang
 */
public class StrategyContext {
    private Strategy strategy;

    public StrategyContext(Strategy strategy) {
        this.strategy = strategy;
    }

    public int run(int a, int b) {
        return strategy.operation(a, b);
    }
}

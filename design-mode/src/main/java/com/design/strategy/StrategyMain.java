package com.design.strategy;

/**
 * @author wuyang
 */
public class StrategyMain {
    public static void main(String[] args) {
        StrategyContext strategyContext = new StrategyContext(new SumStrategy());
        System.out.println(strategyContext.run(3, 2));
        strategyContext = new StrategyContext(new MinusStrategy());
        System.out.println(strategyContext.run(3, 2));
    }
}

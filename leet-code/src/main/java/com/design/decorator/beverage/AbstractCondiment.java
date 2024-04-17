package com.design.decorator.beverage;

/**
 * @author Wu.Chunyang
 */
public abstract class AbstractCondiment implements Beverage {
    int cost;

    public AbstractCondiment(int cost) {
        this.cost = cost;
    }
}

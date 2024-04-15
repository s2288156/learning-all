package com.design.decorator;

/**
 * @author Wu.Chunyang
 */
public abstract class AbstractCondiment implements Beverage {
    int cost;

    public AbstractCondiment(int cost) {
        this.cost = cost;
    }
}

package com.design.decorator.beverage;

/**
 * @author Wu.Chunyang
 */
public class Mongo extends AbstractCondiment {
    private final Beverage beverage;

    public Mongo(Beverage beverage) {
        super(2);
        this.beverage = beverage;
    }

    @Override
    public String description() {
        return beverage.description() + " + Mongo(2)";
    }

    @Override
    public int cost() {
        return beverage.cost() + cost;
    }
}

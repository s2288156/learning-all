package com.design.decorator.beverage;

/**
 * @author Wu.Chunyang
 */
public class Lemon extends AbstractCondiment {
    private final Beverage beverage;

    public Lemon(Beverage beverage) {
        super(4);
        this.beverage = beverage;
    }

    @Override
    public String description() {
        return beverage.description() + " + Lemon(4)";
    }

    @Override
    public int cost() {
        return beverage.cost() + cost;
    }
}

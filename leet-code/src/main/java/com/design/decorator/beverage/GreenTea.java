package com.design.decorator.beverage;

/**
 * @author Wu.Chunyang
 */
public class GreenTea implements Beverage {

    @Override
    public String description() {
        return "this is green tea(" + cost() + ")";
    }

    @Override
    public int cost() {
        return 6;
    }
}

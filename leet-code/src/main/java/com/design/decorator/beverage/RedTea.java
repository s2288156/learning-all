package com.design.decorator.beverage;

/**
 * @author Wu.Chunyang
 */
public class RedTea implements Beverage {

    @Override
    public String description() {
        return "this is red tea(" + cost() + ")";
    }

    @Override
    public int cost() {
        return 5;
    }
}

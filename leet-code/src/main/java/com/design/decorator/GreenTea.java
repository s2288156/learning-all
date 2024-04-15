package com.design.decorator;

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

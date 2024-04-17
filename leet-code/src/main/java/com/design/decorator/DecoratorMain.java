package com.design.decorator;

import com.design.decorator.beverage.Beverage;
import com.design.decorator.beverage.Lemon;
import com.design.decorator.beverage.Mongo;
import com.design.decorator.beverage.RedTea;

/**
 * @author Wu.Chunyang
 */
public class DecoratorMain {
    public static void main(String[] args) {
        Beverage redTea = new RedTea();
        Beverage addLemon = new Lemon(redTea);
        Beverage firstMongo = new Mongo(addLemon);
        Beverage secondMongo = new Mongo(firstMongo);
        System.out.println(secondMongo.description() + " | " + secondMongo.cost());
    }
}

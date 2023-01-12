package com.learn.gof23.factory.simple;

import java.math.BigDecimal;

/**
 * @author Wu.Chunyang
 */
public class NormalCash implements Cash{
    @Override
    public BigDecimal acceptCash(double price, int num) {
        System.out.println("this is NormalCash");
        return new BigDecimal(price).multiply(new BigDecimal(num));
    }
}

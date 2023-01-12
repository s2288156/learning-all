package com.learn.gof23.factory.simple;

import java.math.BigDecimal;

/**
 * @author Wu.Chunyang
 */
public class RebateCash extends NormalCash {

    private BigDecimal rebate;

    public RebateCash(double rebate) {
        this.rebate = new BigDecimal(rebate);
    }

    @Override
    public BigDecimal acceptCash(double price, int num) {
        System.out.println("this is RebateCash");
        return super.acceptCash(price, num).multiply(rebate);
    }
}

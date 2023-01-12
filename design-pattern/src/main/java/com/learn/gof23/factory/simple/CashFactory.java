package com.learn.gof23.factory.simple;

/**
 * @author Wu.Chunyang
 */
public class CashFactory {
    public static Cash create(CashTypeEnum cashType, double rebate) {
        switch (cashType) {
            case NORMAL: {
                return new NormalCash();
            }
            case REBATE: {
                return new RebateCash(rebate);
            }
        }
        return null;
    }
}

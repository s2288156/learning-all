package com.learn.gof23.factory.simple;

/**
 * @author Wu.Chunyang
 */
public class CashMain {
    public static void main(String[] args) {
        Cash cash = CashFactory.create(CashTypeEnum.NORMAL, 1.0);
        System.out.println(cash.acceptCash(100, 10));
        Cash cash1 = CashFactory.create(CashTypeEnum.REBATE, 0.8);
        System.out.println(cash1.acceptCash(100, 10).toBigInteger());
    }
}

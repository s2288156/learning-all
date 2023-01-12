package com.learn.gof23.factory.simple;

import java.math.BigDecimal;

/**
 * @author Wu.Chunyang
 */
public interface Cash {
    BigDecimal acceptCash(double price, int num);
}

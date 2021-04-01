package com.learning.midium;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author wcy
 */
@Slf4j
class M1006Test {

    @Test
    void testClumsy() {
        M1006 m1006 = new M1006();
        int clumsy = m1006.clumsy(4);
        log.info("{}", clumsy);
        assertEquals(7, clumsy);

        clumsy = m1006.clumsy(3);
        log.info("{}", clumsy);
        assertEquals(6, clumsy);

        clumsy = m1006.clumsy(2);
        log.info("{}", clumsy);
        assertEquals(2, clumsy);

        clumsy = m1006.clumsy(1);
        log.info("{}", clumsy);
        assertEquals(1, clumsy);
    }

    @Test
    void testGreaterThan4() {
        M1006 m1006 = new M1006();
        int clumsy;

        clumsy = m1006.clumsy(5);
        log.info("{}", clumsy);
        assertEquals(7, clumsy);

        clumsy = m1006.clumsy(6);
        log.info("{}", clumsy);
        assertEquals(8, clumsy);

        clumsy = m1006.clumsy(10);
        log.info("{}", clumsy);
        assertEquals(12, clumsy);
    }
}
package com.learning.midium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author wcy
 */
class M1239Test {

    static Stream<Arguments> testCaseParams() {
        return Stream.of(
                Arguments.of(Collections.singletonList("abcd"), 4),
                Arguments.of(Arrays.asList("b", "c"), 2),
                Arguments.of(Arrays.asList("a", "b", "c"), 3)
        );
    }

    @MethodSource("testCaseParams")
    @ParameterizedTest
    void maxLengthTest(List<String> arr, int expectedLength) {
        M1239 m1239 = new M1239();
        int length = m1239.maxLength(arr);
        Assertions.assertEquals(expectedLength, length);
    }
}
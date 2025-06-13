package com.demo;

import java.util.function.Function;

/**
 * @author Wu.Chunyang
 */
public class FunctionDemo {

    public static void main(String[] args) {
        System.out.println(testFunction(s -> s + " go"));
    }

    private static String testFunction(Function<String, String> f) {
        return f.apply("test");
    }
}

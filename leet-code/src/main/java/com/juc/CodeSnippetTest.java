package com.juc;

/**
 * @author Wu.Chunyang
 */
public class CodeSnippetTest {
    public static void main(String[] args) {
        for (int i = 0; i < 8; i++) {
            System.out.println(i + "&1: " + (i & 1));
        }
    }
}

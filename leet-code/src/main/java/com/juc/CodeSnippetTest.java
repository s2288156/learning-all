package com.juc;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Wu.Chunyang
 */
public class CodeSnippetTest {
    public static void main(String[] args) {
        LocalDateTime d = LocalDateTime.now();
        System.out.println(d.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
    }
}

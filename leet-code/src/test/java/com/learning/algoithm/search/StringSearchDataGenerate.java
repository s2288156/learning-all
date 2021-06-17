package com.learning.algoithm.search;

import lombok.Cleanup;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.nio.charset.StandardCharsets;

/**
 * @author wcy
 */
public class StringSearchDataGenerate {
    @SneakyThrows
    @Test
    void outputStringTxt() {
        File file = new File("src/test/resources/files/a.txt");
        @Cleanup FileWriter writer = new FileWriter(file);
        @Cleanup BufferedWriter bufferedWriter = new BufferedWriter(writer);
        for (int i = 0; i < 5; i++) {
            bufferedWriter.write("go" + i);
        }
    }

    @Test
    void testCharCode() {
        String str = "ABCZabcz";
        for (char c : str.toCharArray()) {
            System.out.println(c + " = " + (int) c);
        }
    }
}

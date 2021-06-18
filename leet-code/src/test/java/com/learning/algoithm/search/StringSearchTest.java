package com.learning.algoithm.search;

import lombok.Cleanup;
import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Random;

/**
 * @author wcy
 */
public class StringSearchTest {
    private final int minChar = 33;
    private final int maxChar = 126;
    private final String aTxtFilePath = FileUtils.getUserDirectoryPath() + "/testData/a.txt";

    @SneakyThrows
    @Test
    void outputStringTxt() {
        File file = new File(aTxtFilePath);
        FileUtils.writeStringToFile(file, "", StandardCharsets.UTF_8);
        @Cleanup FileWriter writer = new FileWriter(file);
        @Cleanup BufferedWriter bufferedWriter = new BufferedWriter(writer);
        // 1000000000 ≈ 980MB
        int M_9 = 10000000;
        int M_95 = 100000000;
        int M_950 = 1000000000;
        outputTxtFile(bufferedWriter, M_9);
    }

    private void outputTxtFile(BufferedWriter bufferedWriter, int M_9) throws IOException {
        Random random = new Random();
        int randomChar;
        for (int i = 0; i < M_9; i++) {
            randomChar = random.nextInt(maxChar - minChar) + minChar;
            bufferedWriter.write((char) randomChar);
        }
    }

    /**
     * 65-90: A-Z
     * 91-96: [\]^_`
     * 97-122: a-z
     * 33-126: 数字、英文、常用标点符号
     */
    @Test
    void testCharCode() {
//        String str = "ABCZabcz";
//        for (char c : str.toCharArray()) {
//            System.out.println(c + " = " + (int) c);
//        }
//        for (int i = 33; i <= 126; i++) {
//            System.out.println(i + " = " + (char) i);
//        }
        System.out.println(FileUtils.getUserDirectoryPath());
    }

}

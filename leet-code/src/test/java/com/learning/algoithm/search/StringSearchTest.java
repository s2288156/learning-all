package com.learning.algoithm.search;

import lombok.Cleanup;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.util.StopWatch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Random;
import java.util.stream.Stream;

/**
 * @author wcy
 */
@Slf4j
public class StringSearchTest {
    private final int minChar = 33;
    private final int maxChar = 126;
    private final String m9TxtFilePath = FileUtils.getUserDirectoryPath() + "/testData/9m.txt";
    private final File m9TxtFile = new File(m9TxtFilePath);
    private final String m95TxtFilePath = FileUtils.getUserDirectoryPath() + "/testData/95m.txt";
    private final File m95TxtFile = new File(m95TxtFilePath);
    // 1000000000 ≈ 980MB
    int M_9 = 10000000;
    int M_95 = 100000000;
    int M_950 = 1000000000;

    @BeforeEach
    void setUp() {
        if (!m9TxtFile.exists()) {
            outputStringTxt(m9TxtFile, M_9);
        }
        if (!m95TxtFile.exists()) {
            outputStringTxt(m95TxtFile, M_95);
        }
    }

    @SneakyThrows
    void outputStringTxt(File file, int length) {
        FileUtils.writeStringToFile(file, "", StandardCharsets.UTF_8);
        @Cleanup FileWriter writer = new FileWriter(file);
        @Cleanup BufferedWriter bufferedWriter = new BufferedWriter(writer);
        outputTxtFile(bufferedWriter, length);
    }

    private void outputTxtFile(BufferedWriter bufferedWriter, int M_9) throws IOException {
        Random random = new Random();
        int randomChar;
        for (int i = 0; i < M_9; i++) {
            randomChar = random.nextInt(maxChar - minChar) + minChar;
            bufferedWriter.write((char) randomChar);
        }
    }

    // =========================================== testBfSearchIndexParams ===============================================
    static Stream<Arguments> testBfSearchIndexParams() {
        return Stream.of(
//                Arguments.of("abcdefg", "cde", 2),
//                Arguments.of("abcdefg", "de", 3),
//                Arguments.of("abcdefg", "e", 4),
//                Arguments.of("abcdefg", "e", 4),
                Arguments.of("abaaaaaa", "baa", 1)
        );
    }

    // =========================================== 1.BFSearch.searchIndex Test ===============================================
    @MethodSource("testBfSearchIndexParams")
    @ParameterizedTest
    void testBfSearchIndex(String str, String searchStr, int index) {
        log.warn("{}, {}, {}", str, searchStr, index);
        StringSearch search = new BFSearch();
        Assertions.assertEquals(index, search.searchIndex(str, searchStr));
    }

    @SneakyThrows
    @Test
    void testBfSearchIndexForBigdata() {
        StopWatch stopWatch = new StopWatch();
        StringSearch search = new BFSearch();
        @Cleanup FileReader reader = new FileReader(m95TxtFilePath);
        @Cleanup BufferedReader bufferedReader = new BufferedReader(reader);
        String str = bufferedReader.readLine();

        stopWatch.start();
        int index = search.searchIndex(str, "!.`I=ZTx.PnO+`q-1");
        stopWatch.stop();

        log.info("95M txtFile, index = {}, time = {}", index, stopWatch.getTotalTimeSeconds());
    }
    // =========================================== 1.BFSearch.searchIndex Test ===============================================

    // =========================================== 2.BFSearch.count Test ===============================================

    @SneakyThrows
    @Test
    void testBfSearchCountForBigdata() {
        StopWatch stopWatch = new StopWatch();
        StringSearch search = new BFSearch();
        @Cleanup FileReader reader = new FileReader(m95TxtFilePath);
        @Cleanup BufferedReader bufferedReader = new BufferedReader(reader);
        String str = bufferedReader.readLine();

        stopWatch.start();
        int count = search.count(str, "XX");
        stopWatch.stop();

        log.info("9M txtFile, count = {}, time = {}", count, stopWatch.getTotalTimeSeconds());
    }

    // =========================================== 2.BFSearch.count Test ===============================================

    @MethodSource("testBfSearchIndexParams")
    @ParameterizedTest
    void testBMSearchIndex(String str, String searchStr, int index) {
        log.warn("{}, {}, {}", str, searchStr, index);
        StringSearch search = new BMSearch();
        Assertions.assertEquals(index, search.searchIndex(str, searchStr));
    }
}

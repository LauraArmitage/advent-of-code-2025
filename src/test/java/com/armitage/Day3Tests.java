package com.armitage;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day3Tests {

    @ParameterizedTest
    @MethodSource("findMaxJoltageTestData")
    void findMaxJoltageTest(String input, int expectedOutput) {
        int actualOutput = Day3.findMaxJoltage(List.of(input)).getFirst();

        assertEquals(expectedOutput, actualOutput);
    }

    static Stream<Arguments> findMaxJoltageTestData() {
        return Stream.of(
                Arguments.of("987654321111111", 98),
                Arguments.of("1222229", 29),
                Arguments.of("11111111", 11)
        );
    }

    @ParameterizedTest
    @MethodSource("findMaxJoltage12DigitTestData")
    void findMaxJoltage12DigitTest(String input, long expectedOutput) {
        long actualOutput = Day3.findMaxJoltage12Digit(List.of(input)).getFirst();

        assertEquals(expectedOutput, actualOutput);
    }

    static Stream<Arguments> findMaxJoltage12DigitTestData() {
        return Stream.of(
                Arguments.of("987654321111111", 987654321111L),
                Arguments.of("811111111111119", 811111111119L),
                Arguments.of("111111111111", 111111111111L),
                Arguments.of("234234234234278", 434234234278L)
        );
    }

    @Test
    void findMaxJoltageExampleDataTest() throws IOException {
        List<Integer> actualList = Day3.findMaxJoltage(FileReader.read("src/test/java/resources/day3-example.txt"));

        assertEquals(List.of(98, 89, 78, 92), actualList);
    }

    @Test
    void sumMaxJoltageExampleDataTest() throws IOException {
        long actualResult = Day3.sumMaxJoltage(FileReader.read("src/test/java/resources/day3-example.txt"));

        assertEquals(357, actualResult);
    }

    @Test
    void sumMaxJoltageRealDataTest() throws IOException {
        long actualResult = Day3.sumMaxJoltage(FileReader.read("src/test/java/resources/day3-data.txt"));

        assertEquals(16927, actualResult);
    }
}

package com.armitage;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day2Tests {

    @ParameterizedTest
    @MethodSource("parseIdsTestData")
    void parseIdsListTest(String input, List<String> expectedOutput) {
        List<String> actualList = Day2.parseIdsToList(input);

        assertEquals(expectedOutput, actualList);
    }

    static Stream<Arguments> parseIdsTestData() {
        return Stream.of(
            Arguments.of("11-22", List.of("11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22")),
            Arguments.of("456123789-456123790", List.of("456123789", "456123790")),
            Arguments.of("1-2,4-5,7-9", List.of("1", "2", "4", "5", "7", "8", "9"))
        );
    }

    @ParameterizedTest
    @MethodSource("getInvalidIdsTestData")
    void getInvalidIdsTest(String input, List<String> expectedOutput) {
        List<String> actualList = Day2.getInvalidIds(input);

        assertEquals(expectedOutput, actualList);
    }

    static Stream<Arguments> getInvalidIdsTestData() {
        return Stream.of(
            Arguments.of("11-22", List.of("11", "22")),
            Arguments.of("95-115", List.of("99")),
            Arguments.of("11-22,95-115,998-1012,1188511880-1188511890,222220-222224," +
                    "1698522-1698528,446443-446449,38593856-38593862,565653-565659," +
                    "824824821-824824827,2121212118-2121212124", List.of("11", "22", "99", "1010", "1188511885", "222222", "446446", "38593859"))
        );
    }

    @ParameterizedTest
    @MethodSource("getInvalidIds2TestData")
    void getInvalidIds2Test(String input, List<String> expectedOutput) {
        List<String> actualList = Day2.getInvalidIds2(input);

        assertEquals(expectedOutput, actualList);
    }

    static Stream<Arguments> getInvalidIds2TestData() {
        return Stream.of(
            Arguments.of("11-22", List.of("11", "22")),
            Arguments.of("95-115", List.of("99", "111")),
            Arguments.of("11-22,95-115,998-1012,1188511880-1188511890,222220-222224," +
                    "1698522-1698528,446443-446449,38593856-38593862,565653-565659," +
                    "824824821-824824827,2121212118-2121212124", List.of("11", "22", "99", "111", "999", "1010", "1188511885", "222222", "446446", "38593859", "565656", "824824824", "2121212121"))
        );
    }

    @ParameterizedTest
    @MethodSource("sumInvalidIdsTestData")
    void sumInvalidIdsTest(String input, long expectedOutput) {
        long actualAnswer = Day2.sumInvalidIds(input);

        assertEquals(expectedOutput, actualAnswer);
    }

    static Stream<Arguments> sumInvalidIdsTestData() {
        return Stream.of(
            Arguments.of("11-22", 33),
            Arguments.of("95-115", 99),
            Arguments.of("11-22,95-115,998-1012,1188511880-1188511890,222220-222224," +
                    "1698522-1698528,446443-446449,38593856-38593862,565653-565659," +
                    "824824821-824824827,2121212118-2121212124", 1227775554)
        );
    }

    @Test
    void sumInvalidIdsRealDataTest() throws IOException {
        List<String> input = FileReader.read("src/test/java/resources/day2-data.txt");
        long actualAnswer = Day2.sumInvalidIds(input.getFirst());

        assertEquals(31210613313L, actualAnswer);
    }

    @Test
    void sumInvalidIds2RealDataTest() throws IOException {
        List<String> input = FileReader.read("src/test/java/resources/day2-data.txt");
        long actualAnswer = Day2.sumInvalidIds2(input.getFirst());

        assertEquals(41823587546L, actualAnswer);
    }
}

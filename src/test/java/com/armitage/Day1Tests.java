package com.armitage;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day1Tests {

    @ParameterizedTest
    @MethodSource("provideExamplesAndExpectedAnswer1")
    void calculateEndPositionTestCases(String input, int expectedPosition) throws Exception {
        List<String> list = Arrays.stream(input.split("\\n")).toList();
        int actualPosition = Day1.calculateEndPosition(list);

        assertEquals(expectedPosition, actualPosition);
    }

    static Stream<Arguments> provideExamplesAndExpectedAnswer1() {
        return Stream.of(
                Arguments.of("L10\nR5", 45),
                Arguments.of("R40\nR10\nL112", 88),
                Arguments.of("L3\nR3\nL3\nR3", 50),
                Arguments.of("R49\nL99\nR99\nL98", 1),
                Arguments.of("R49\nL99\nR99\nL99", 0),
                Arguments.of("R49\nL99\nR99\nL100", 99),
                Arguments.of("", 50)
        );
    }

    @ParameterizedTest
    @MethodSource("provideExamplesAndExpectedAnswer2")
    void calculateTimesLandingOn0TestCases(String input, int expectedCount) throws Exception {
        List<String> list = Arrays.stream(input.split("\\n")).toList();
        int actualCount = Day1.calculateTimesLandingOn0(list);

        assertEquals(expectedCount, actualCount);
    }

    static Stream<Arguments> provideExamplesAndExpectedAnswer2() {
        return Stream.of(
                Arguments.of("R40\nR10\nL112", 1),
                Arguments.of("L50\nR50\nL50\nR50", 2),
                Arguments.of("L10\nL40\nL100\nL90\nL10", 3),
                Arguments.of("", 0)
        );
    }

    @Test
    void calculateTimesLandingOn0FileExampleCase() throws Exception {
        List<String> list = FileReader.read("src/test/java/resources/day1-example.txt");
        int actualPosition = Day1.calculateTimesLandingOn0(list);

        assertEquals(3, actualPosition);
    }

    @Test
    void calculateTimesLandingOn0RealCase() throws Exception {
        List<String> list = FileReader.read("src/test/java/resources/day1-data.txt");
        int actualPosition = Day1.calculateTimesLandingOn0(list);

        assertEquals(1084, actualPosition);
    }

    @ParameterizedTest
    @MethodSource("provideExamplesAndExpectedAnswer3")
    void calculateTimesPassing0FileTestCases(String input, int expectedCount) throws Exception {
        List<String> list = Arrays.stream(input.split("\\n")).toList();
        int actualCount = Day1.calculateTimesPassing0(list);

        assertEquals(expectedCount, actualCount);
    }

    static Stream<Arguments> provideExamplesAndExpectedAnswer3() {
        return Stream.of(
                Arguments.of("R1000", 10),
                Arguments.of("R49\nL99\nR99\nL98", 1),
                Arguments.of("R49\nL99\nR99\nL99", 2),
                Arguments.of("R49\nL99\nR99\nL100", 2),
                Arguments.of("R49\nL99\nR1000\nR99\nL99", 12),
                Arguments.of("", 0)
        );
    }

    @Test
    void calculateTimesPassing0FileExampleCase() throws Exception {
        List<String> list = FileReader.read("src/test/java/resources/day1-example.txt");
        int actualPosition = Day1.calculateTimesPassing0(list);

        assertEquals(6, actualPosition);
    }

    @Test
    void calculateTimesPassing0RealCase() throws Exception {
        List<String> list = FileReader.read("src/test/java/resources/day1-data.txt");
        int actualPosition = Day1.calculateTimesPassing0(list);

        assertEquals(6475, actualPosition);
    }
}

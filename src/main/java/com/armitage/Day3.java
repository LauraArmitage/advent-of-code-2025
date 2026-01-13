package com.armitage;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Day3 {

    public static List<Integer> findMaxJoltage(List<String> input) {
        return input.stream().map(bankDigits -> {
            int currentHighestJoltage = 0;

            for (int firstIndex = 0; firstIndex < bankDigits.length(); firstIndex++) {
                for (int secondIndex = firstIndex+1; secondIndex < bankDigits.length(); secondIndex++) {
                    int numberToCompare = parseInt(""+bankDigits.charAt(firstIndex)+bankDigits.charAt(secondIndex));
                    if (numberToCompare > currentHighestJoltage) {
                        currentHighestJoltage = numberToCompare;
                    }
                }
            }
            return currentHighestJoltage;
        }).toList();
    }

    public static long sumMaxJoltage(List<String> input) {
        return findMaxJoltage(input).stream().mapToInt(Integer::intValue).sum();
    }

    public static List<Long> findMaxJoltage12Digit(List<String> input) {
        int digitsInJoltage = 12;

        List<Long> combinations = getBinaryCombinations(digitsInJoltage);

        return input.stream().map(bankDigits -> {

            long maximumJoltage = 0L;

            for (long combination : combinations) {
                long joltage = getJoltage(combination, bankDigits);

                if (joltage > maximumJoltage) {
                    maximumJoltage = joltage;
                }
            }

            return maximumJoltage;
        }).toList();
    }

    private static long getJoltage(long combination, String bankDigits) {
        String binary = Long.toBinaryString(combination);

        StringBuilder joltageString = new StringBuilder();

        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '1') {
                joltageString.append(bankDigits.charAt(i));
            }
        }

        return parseLong(joltageString.toString());
    }

    private static List<Long> getBinaryCombinations(int digitsInJoltage) {
        LongStream range = LongStream.range(0b0, (long) Math.pow(2, digitsInJoltage));
        List<Long> items = range.boxed().toList();
        LongStream longStream = range
                .filter(counter -> Long.bitCount(counter) == digitsInJoltage);
        return  longStream
                .boxed().toList();
    }

//    public static List<Long> findMaxJoltage12Digit(List<String> input) {
//        int digitsInJoltage = 12;
//        int maxIndex = digitsInJoltage - 1;
//
//        return input.stream().map(bankDigits -> {
//            long currentHighestJoltage = 0;
//            int[] digitsInUse = IntStream.range(0, digitsInJoltage).toArray();
//
//            int indexToMove = maxIndex;
//            boolean notFinished = true;
//            do {
//                currentHighestJoltage = getHighestJoltage(bankDigits, digitsInUse, currentHighestJoltage);
//
//                int newValueOfIndexToMove = digitsInUse[indexToMove] + 1;
//                int reverseIndex = maxIndex - indexToMove;
//                int maxIndexThisIndexCanMove = bankDigits.length() - reverseIndex;
//                if (newValueOfIndexToMove < maxIndexThisIndexCanMove) {
//                    digitsInUse[indexToMove]++;
//
//                    if (reverseIndex > 0) {
//                        for (int i = 1; i <= reverseIndex; i++) {
//                            digitsInUse[indexToMove+i] = newValueOfIndexToMove + i;
//                        }
//                        indexToMove = maxIndex;
//                    }
//
//                } else {
//                    indexToMove--;
//                }
//            } while (notFinished);
//
//            return currentHighestJoltage;
//        }).toList();
//    }

    private static long getHighestJoltage(String bankDigits, int[] digitsInUse, long currentHighestJoltage) {
        String joltageChars = Arrays.stream(digitsInUse)
                .mapToObj(i -> ""+bankDigits.charAt(i))
                .collect(Collectors.joining());

        long joltageToCompare = parseLong(joltageChars);

        if (joltageToCompare > currentHighestJoltage) {
            return joltageToCompare;
        }

        return currentHighestJoltage;
    }
}

package com.armitage;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Long.parseLong;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Day2 {

    private static final Pattern invalidId1Pattern = Pattern.compile("^(.*)\\1$");
    private static final Pattern invalidId2Pattern = Pattern.compile("^(.*)(\\1)+$");

    public static List<String> parseIdsToList(String input) {
        return Arrays.stream(input.split(","))
                .map(range -> {
                    String[] parts = range.split("-");
                    long currentNumber = parseLong(parts[0]);
                    long endingNumber = parseLong(parts[1]);

                    List<Long> numbers = new ArrayList<>();
                    numbers.add(currentNumber);

                    while (++currentNumber <= endingNumber) {
                        numbers.add(currentNumber);
                    }

                    return numbers;
                })
                .flatMap(Collection::stream)
                .map(Object::toString)
                .toList();
    }

    public static List<String> getInvalidIds(String input) {
        return parseIdsToList(input).stream()
                .filter(id -> {
                    Matcher matcher = invalidId1Pattern.matcher(id);
                    boolean b = matcher.matches();
                    return !id.startsWith("0") && b;
                })
                .toList();
    }

    public static List<String> getInvalidIds2(String input) {
        return parseIdsToList(input).stream()
                .filter(id -> !id.startsWith("0") && invalidId2Pattern.matcher(id).matches())
                .toList();
    }

    public static long sumInvalidIds(String input) {
        return AocHelper.sumList(getInvalidIds(input));
    }

    public static long sumInvalidIds2(String input) {
        return AocHelper.sumList(getInvalidIds2(input));
    }
}

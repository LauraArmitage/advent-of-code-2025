package com.armitage;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AocHelper {

    public static Long sumList(List<String> input) {
        return input
                .stream()
                .mapToLong(Long::parseLong)
                .sum();
    }
}

package com.dart69.core.utils;

import java.util.function.Function;

public final class StringUtils {
    private StringUtils() {
    }

    public static String capitalized(String input) {
        final var buffer = new StringBuilder(input.length() * 2);
        for (var i = 0; i < input.length(); ++i) {
            final Function<Character, Character> transform = (i == 0) ? Character::toUpperCase : Character::toLowerCase;
            buffer.append(transform.apply(input.charAt(i)));
        }
        return buffer.toString();
    }
}

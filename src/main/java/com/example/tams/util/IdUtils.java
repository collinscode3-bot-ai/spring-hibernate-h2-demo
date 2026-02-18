package com.example.tams.util;

import java.util.Random;

public class IdUtils {
    private static final Random random = new Random();

    public static String generateId(String prefix) {
        int number = random.nextInt(100000000); // 0 to 99999999
        return prefix + String.format("%08d", number);
    }
}

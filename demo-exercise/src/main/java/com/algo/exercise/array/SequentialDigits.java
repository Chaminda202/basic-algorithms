package com.algo.exercise.array;

import java.util.ArrayList;
import java.util.List;

public class SequentialDigits {
    public static void main(String[] args) {
        System.out.println(findSequentialDigits(1000, 13000));
    }

    private static List<Integer> findSequentialDigits(int low, int high) {
        String digits = "123456789";
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            for (int j = 0; i + j <= digits.length(); j++) {
                String str = digits.substring(j, j + i);
                int val = Integer.parseInt(str);
                if (val >= low && val <= high)
                    result.add(val);
            }
        }
        return result;
    }
}

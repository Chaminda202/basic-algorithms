package com.algo.exercise.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        System.out.println(checkTwoSum(new int[] {2, 7, 11, 15}, 9));
        System.out.println(checkTwoSum2(new int[] {2, 7, 11, 15}, 26));
    }

    private static List<Integer> checkTwoSum (int [] input, int target) {
        for (int i = 0; i < input.length - 1; i++) {
            for (int j = i + 1; j < input.length; j++) {
                if (input[i] + input[j] == target) {
                    return Arrays.asList(i, j);
                }
            }
        }
        return new ArrayList<>();
    }

    private static List<Integer> checkTwoSum2 (int [] input, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < input.length; i++) {
            int diff = target - input[i];
            if (map.containsKey(diff)) {
                return Arrays.asList(map.get(diff), i);
            }
            map.put(input[i], i);
        }
        return new ArrayList<>();
    }
}

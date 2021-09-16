package com.algo.exercise.array;

import java.util.ArrayList;
import java.util.List;

public class GreatestNumberOfCandies {
    public static void main(String[] args) {
        System.out.println(findGreatestNumberOfCandies(new int[] {2, 3, 5, 1, 3}, 3));
    }

    private static List<Boolean> findGreatestNumberOfCandies(int [] arr, int extraCandi) {
        List<Boolean> result = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] + extraCandi >= max) {
                result.add(true);
            } else
                result.add(false);
        }
        return result;
    }
}

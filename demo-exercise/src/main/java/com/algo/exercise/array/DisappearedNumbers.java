package com.algo.exercise.array;

import java.util.ArrayList;
import java.util.List;

public class DisappearedNumbers {
    public static void main(String[] args) {
        System.out.println(findDisappearedNumbers(new int[] {1, 2, 2, 1, 4}));
    }

    private static List<Integer> findDisappearedNumbers(int [] numbers) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            int n = Math.abs(numbers[i]);
            if (n - 1 >= 0 && numbers[n - 1] > 0) {
                numbers[n -1] = -1 * numbers[n -1];
            }
        }
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > 0) {
                list.add(i + 1);
            }
        }
        return list;
    }
}

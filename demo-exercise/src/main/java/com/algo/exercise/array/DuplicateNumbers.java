package com.algo.exercise.array;

import java.util.ArrayList;
import java.util.List;

public class DuplicateNumbers {
    public static void main(String[] args) {
        System.out.println(findDuplicateNumbers(new int[]{1, 2, 2, 1, 3}));
        System.out.println(findDuplicateNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
    }

    private static List<Integer> findDuplicateNumbers(int [] arr) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            int n = Math.abs(arr[i]);
            if (n - 1 >= 0 && arr[n - 1] > 0)
                arr[n - 1] = -1 * arr[n - 1];
            else
                list.add(n);
        }
        return list;
    }
}

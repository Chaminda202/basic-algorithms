package com.algo.exercise.array;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MoveZeroes {
    public static void main(String[] args) {
        System.out.println(checkMoveZeroes(new int[] {1, 0, 3, 1, 0, 0, 5}));
    }

    private static List<Integer> checkMoveZeroes(int [] arr) {
        int current = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                arr[current] = arr[i];
                current++;
            }
        }
        for (int i = current; i < arr.length; i++) {
            arr[i] = 0;
        }
        return Arrays.stream(arr).boxed().collect(Collectors.toList());
    }
}

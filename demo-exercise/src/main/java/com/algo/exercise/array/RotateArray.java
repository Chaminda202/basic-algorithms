package com.algo.exercise.array;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RotateArray {
    public static void main(String[] args) {
        System.out.println(findRotateArray(new int[] {1, 2, 3, 4, 5}, 3));
    }

    private static List<Integer> findRotateArray(int [] arr, int k) {
        k = k % arr.length;
        reverseArray(arr, 0, arr.length - 1);
        reverseArray(arr, 0, k - 1);
        reverseArray(arr, k, arr.length - 1);
        return Arrays.stream(arr).boxed().collect(Collectors.toList());
    }

    private static void reverseArray(int [] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}

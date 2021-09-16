package com.algo.exercise.array;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ProductExceptSelf {
    public static void main(String[] args) {
        System.out.println(findProductExceptSelf(new int []{1, 2, 3, 4}));
    }

    private static List<Integer> findProductExceptSelf(int [] arr) {
        int [] newArr = new int [arr.length];
        newArr[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            newArr[i] = newArr[i - 1] * arr[i - 1];
        }
        int right = 1;
        for (int i = arr.length - 1; i >= 0; i--) {
            newArr[i] = newArr[i] * right;
            right = right * arr[i];
        }
        return Arrays.stream(newArr).boxed().collect(Collectors.toList());
    }
}

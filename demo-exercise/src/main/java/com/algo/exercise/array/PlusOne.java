package com.algo.exercise.array;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PlusOne {
    public static void main(String[] args) {
        System.out.println(checkPlusOne(new int[] {9, 9, 9}));
    }

    private static List<Integer> checkPlusOne(int [] arr) {
        int curry = 1;
        for (int i = arr.length - 1; i >=0 && curry == 1 ; i--) {
            int temp = arr[i] + curry;
            if (temp >= 10) {
                curry = 1;
                arr[i] = temp % 10;
            }else {
                curry = 0;
                arr[i] = temp;
            }
        }
        if (curry == 1) {
            int [] newArr = new int[arr.length + 1];
            newArr[0] = 1;
            for (int i = 1; i < newArr.length; i++) {
                newArr[i] = arr[i - 1];
            }
            return Arrays.stream(newArr).boxed().collect(Collectors.toList());
        }
        return Arrays.stream(arr).boxed().collect(Collectors.toList());
    }
}

package com.algo.exercise.array;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MergeSortedArrays {
    public static void main(String[] args) {
        System.out.println(mergeArrays(new int[] {1, 2, 3, 0, 0, 0}, 3, new int[] {2, 5, 6}, 3));
    }
    //merge two sorted list, num1 size equal m + n
    private static List<Integer> mergeArrays(int [] num1, int m, int [] num2, int n) {
        m--; // last index without default elements (0)
        n--; // last index of the array
        for (int i = m + n + 1; i >= 0 ; i--) {
            int a = m >= 0 ? num1[m] : Integer.MIN_VALUE;
            int b = n >= 0 ? num2[n] : Integer.MIN_VALUE;
            if (a > b) {
               num1[i] = a;
               m--;
            }else {
                num1[i] = b;
                n--;
            }
        }
        return Arrays.stream(num1).boxed().collect(Collectors.toList());
    }
}

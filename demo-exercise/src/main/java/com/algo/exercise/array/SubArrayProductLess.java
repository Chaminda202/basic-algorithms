package com.algo.exercise.array;

public class SubArrayProductLess {
    public static void main(String[] args) {
        System.out.println(countSubArrayProductLessThan(new int[] {10, 5, 2, 6, 3, 5}, 100));
    }

    private static int countSubArrayProductLessThan(int [] arr, int k) {
        if (k <= 1)
            return 0;
        int count = 0, product = 1, left = 0;
        for (int i = 0; i < arr.length; i++) {
            product = product * arr[i];
            while (product >= k) {
                product = product / arr[left++];
            }
            count = count + (i - left) + 1;
        }
        return count;
    }
}

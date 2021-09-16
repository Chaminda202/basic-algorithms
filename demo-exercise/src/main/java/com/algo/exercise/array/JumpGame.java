package com.algo.exercise.array;

public class JumpGame {
    public static void main(String[] args) {
        System.out.println(isReachToLastIndex(new int [] {2, 3, 1, 1, 4}));
    }

    private static boolean isReachToLastIndex(int [] arr) {
        int pos = arr.length - 1;
        int prev = pos - 1;

        for (int i = pos; i >= 0; i--) {
            if (pos - prev <= arr[pos] && pos != 0) {
                pos = prev;
                prev = pos - 1;
            } else
                prev--;
        }
        return pos == 0;
    }
}

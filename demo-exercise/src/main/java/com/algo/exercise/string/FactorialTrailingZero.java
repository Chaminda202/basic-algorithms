package com.algo.exercise.string;

public class FactorialTrailingZero {
    public static void main(String[] args) {
        System.out.println(checkTrailingZeros(7));
       /* 7 * 6 * 5 * 4 * 3 * 2 * 1
          7 * (2 * 3) * 5 * (2 * 2) * 3 * 2 * 1 => 2 repeated 5 times, 5 repeated 1 time
       */
    }

    private static int checkTrailingZeros(Integer value) {
        int count = 0;
        while (value > 0) {
            value /= 5; // 2 * 5 -> 5
            count += value;
        }
        return count;
    }
}

package com.algo.exercise.string;

public class Pow {
    public static void main(String[] args) {
        System.out.println(checkPow(2.5, -3));
    }

    private static double checkPow(double x, int n) { // x^n
        double ans = 1.0;
        long num = n;
        if (num < 0) {
            num = -1 * num;
        }
        while (num > 0) {
            if (num % 2 == 0) {
                x = x * x;
                num = num/2;
            } else {
                ans = ans * x;
                num = num -1;
            }
        }
        if (n < 0) {
            return (double)1.0/(double) ans;
        }
        return ans;
    }
}

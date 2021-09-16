package com.algo.exercise.string;

import java.util.Arrays;

public class ReverseString {
    public static void main(String[] args) {
        System.out.println(reverse("Singapore"));
        String a = "erwr wrewr wrewrw  wewew";
        String[] split = a.split(" +");
        System.out.println(Arrays.asList(split));
    }

    private static String reverse(String str) { // using two pointers
        int left = 0;
        int right = str.length() - 1;
        char [] chars = str.toCharArray();
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        return String.valueOf(chars);
    }
}

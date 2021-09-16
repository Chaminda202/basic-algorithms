package com.algo.exercise.string;

public class LongestPalindrome {
    public static void main(String[] args) {
        System.out.println(checkLongestPalindrome("babadeftefet"));
    }

    private static String checkLongestPalindrome(String str) {
        if (str == null || str.length() < 1)
            return null;
        else {
            int start = 0, end = 0;
            for (int i = 0; i < str.length(); i++) {
                int length1 = aroundCenter(str, i, i);
                int length2 = aroundCenter(str, i, i + 1);
                int length = Math.max(length1, length2);
                if (length > end - start) {
                    start = i - (length)/2 + 1;
                    end = i + length/2;
                }
            }
            return str.substring(start, end);
        }
    }

    private static int aroundCenter(String str, int left, int right) {
        while (left >= 0 && right < str.length() && (str.charAt(left) == str.charAt(right))) {
            left--;
            right++;
        }
        return right - left;
    }
}

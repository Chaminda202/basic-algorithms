package com.algo.exercise.string;

public class Palindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome(12321));

        System.out.println(isPalindrome2(12321));
    }

    private static boolean isPalindrome(Integer input) {
        String inputValue = String.valueOf(input);
        StringBuilder reverseValue = new StringBuilder();

        char[] charArray = inputValue.toCharArray();
        for(int i = charArray.length - 1 ; i >= 0 ; i --) {
            reverseValue.append(charArray[i]);
        }
        return inputValue.equals(reverseValue.toString());
    }

    private static boolean isPalindrome2(int input) {
        if (input < 0 || (input % 10 == 0 && input != 0))
            return false;
        int reverseNumber = 0;
        while (input > reverseNumber) {
            int remainder = input % 10;
            reverseNumber = reverseNumber * 10 + remainder;
            input = input / 10;
        }
        return input == reverseNumber || input == reverseNumber / 10;
    }
}

package com.algo.exercise.string;

import java.util.Stack;

public class DecodeString {
    public static void main(String[] args) {
        // System.out.println(checkDecodeString("2[a]3[c]"));
        System.out.println(checkDecodeString("2[q11[sd]er]to"));
    }

    private static String checkDecodeString(String input) {
        Stack<Integer> numStack = new Stack<>();
        Stack<String> strStack = new Stack<>();
        StringBuilder strBuilder = new StringBuilder();
        int length = input.length();
        for (int i = 0; i < length; i++) {
            char c = input.charAt(i);
            if (Character.isDigit(c)) {
                int num = c - '0';
                while (i + 1 < length && Character.isDigit(input.charAt(i + 1))) {
                    num = num * 10 + (input.charAt(i + 1) - '0');
                    i++;
                }
                numStack.push(num);
            } else if ('[' == c) {
                strStack.push(strBuilder.toString());
                strBuilder = new StringBuilder();
            } else if (']' == c) {
                int noOfRepeats = numStack.pop();
                StringBuilder temp = new StringBuilder(strStack.pop());
                while (noOfRepeats > 0) {
                    temp.append(strBuilder);
                    noOfRepeats--;
                }
                strBuilder = temp;
            } else
                strBuilder.append(c);
        }
        return strBuilder.toString();
    }
}

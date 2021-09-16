package com.algo.exercise.array;

public class LengthOfLastWord {
    public static void main(String[] args) {
        System.out.println(checkLengthOfLastWord("Hello World "));
    }

    private static int checkLengthOfLastWord(String str) {
        int count = 0;
        for (int i = str.length() -1; i >= 0 ; i--) {
            char c = str.charAt(i);
            if (c != ' ') {
                count++;
            } else {
                if (count > 0)
                    return count;
            }
        }
        return count;
    }
}

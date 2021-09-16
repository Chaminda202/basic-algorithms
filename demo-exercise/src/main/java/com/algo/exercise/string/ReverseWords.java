package com.algo.exercise.string;

public class ReverseWords {
    public static void main(String[] args) {
        System.out.println(reWords2("How are  you? "));
    }

    private static String reWords(String input) {
        String [] words = input.trim().split(" +");
        StringBuilder output = new StringBuilder();
        for (int i = words.length -1; i >= 0 ; i--) {
            output.append(words[i]).append(" ");
        }
        return output.toString().trim();
    }

    private static String reWords2(String input) {
        StringBuilder output = new StringBuilder();
        int i = input.length() - 1;
        while (i >= 0) {
            if (input.charAt(i) == ' ') {
                i--;
            } else {
                int j = i;
                while (i>=0 && input.charAt(i) != ' '){
                    i--;
                }
                if (output.length() > 0) {
                    output.append(" ");
                }
                for(int k = i + 1; k <= j; k++) {
                    output.append(input.charAt(k));
                }
            }
        }
        return output.toString();
    }
}

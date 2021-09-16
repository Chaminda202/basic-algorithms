package com.algo.exercise.string;

import java.util.HashMap;
import java.util.Map;

public class Anagram {
    public static void main(String[] args) {
        //System.out.println(checkAnagram("anagram", "nagaram"));
        //System.out.println(checkAnagram2("anagram", "nagaram"));
        System.out.println(checkAnagram3("anagram", "nagaram"));

        // Subtracting chars
        System.out.println('A' - 'A');
        System.out.println('a' - 'a');
        System.out.println('5' - '0');
    }

    private static boolean checkAnagram(String input1, String input2) {
        if (input1.length() != input2.length()) {
            return false;
        }
        Map<Character, Integer> map1 = new HashMap<>();
        for (int i = 0; i < input1.length(); i++) {
            char c = input1.charAt(i);
            if (map1.containsKey(c)) {
                map1.put(c, map1.get(c) + 1);
            } else {
                map1.put(c, 1);
            }
        }
        Map<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < input2.length(); i++) {
            char c = input2.charAt(i);
            if (map2.containsKey(c)) {
                map2.put(c, map2.get(c) + 1);
            } else {
                map2.put(c, 1);
            }
        }
        for (Character ch : map1.keySet()) {
            if (map1.get(ch) != map2.get(ch)) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkAnagram2(String input1, String input2) {
        if (input1.length() != input2.length())
            return false;

        int [] count = new int[26]; // length of the alphabet
        for (int i = 0; i < input1.length(); i++) {
            count[input1.charAt(i) - 'a']++; // 'A' - 'A' = 0 , 'a' - 'a' = 0, '5' - '0' = 5
            count[input2.charAt(i) - 'a']--;
        }
        for (int c : count) {
            if (c != 0)
                return false;
        }
        return true;
    }

    private static boolean checkAnagram3(String input1, String input2) {
        if (input1.length() != input2.length())
            return false;

        int [] count = new int[26]; // length of the alphabet
        for (int i = 0; i < input1.length(); i++) {
            count[input1.charAt(i) - 'a']++;
        }

        for (int i = 0; i < input2.length(); i++) {
            count[input2.charAt(i) - 'a']--;
            if (count[input2.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}

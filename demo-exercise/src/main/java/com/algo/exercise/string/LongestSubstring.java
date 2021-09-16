package com.algo.exercise.string;

import java.util.HashMap;
import java.util.Map;

/**
 * Check longest no repeating substring length and substring
 */
public class LongestSubstring {
    public static void main(String[] args) {
        System.out.println(longestSubstringLength("pwwkew"));
        System.out.println(longestSubstring("pwwkew"));
    }

    private static int longestSubstringLength(String str) {
      int strLength = str.length();
      int maxLength = 0;

      Map<Character, Integer> characters = new HashMap<>();
      for(int i = 0, j = 0; j < strLength; j++) {
          if (characters.containsKey(str.charAt(j))) {
              i = Math.max(characters.get(str.charAt(j)), j);
          }
          maxLength = Math.max(maxLength, j - i + 1);
          characters.put(str.charAt(j), j + 1);
      }
      return maxLength;
    }

    private static String longestSubstring(String str) {
        int strLength = str.length();
        String subString = "";
        Map<Character, Integer> characters = new HashMap<>();
        for(int i = 0, j = 0; j < strLength; j++) {
            if (characters.containsKey(str.charAt(j))) {
                i = j;
            }
            characters.put(str.charAt(j), j);
            String temp = str.substring(i, j + 1);
            if (subString != null && (temp.length() >= subString.length())) {
                subString = temp;
            }
        }
        return subString;
    }
}

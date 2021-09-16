package com.algo.exercise.string;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

public class FirstNonRepeatingCharacter {
    public static void main(String[] args) {
        System.out.println(findFirstNonRepeatingCharacter1("indiaN"));
    }

    private static String findFirstNonRepeatingCharacter(String str) {
        Map<Character, Integer> map = new LinkedHashMap<>();

        for (Character chr : str.toCharArray()) {
            map.put(chr, map.containsKey(chr) ? map.get(chr) + 1 : 1);
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1)
                return String.valueOf(entry.getKey());
        }
        return "There is no any non repeating character";
    }

    //Using java 8

    private static String findFirstNonRepeatingCharacter1(String str) {
        Map<Character, Integer> map = new LinkedHashMap<>();

        for (Character chr : str.toCharArray()) {
            map.put(chr, map.containsKey(chr) ? map.get(chr) + 1 : 1);
        }

        Optional<Character> firstMatchingOptional = map.entrySet().stream()
                .filter(k -> k.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst();
        if (firstMatchingOptional.isPresent())
            return String.valueOf(firstMatchingOptional.get());
        return "There is no any non repeating character";
    }

}

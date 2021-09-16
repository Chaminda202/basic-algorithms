package com.algo.exercise.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RepeatedDNASequence {
    public static void main(String[] args) {
        System.out.println(repeatedSequences2("AAAAABBBBBAAAAABBBBBAAAAACCCDDD"));
        System.out.println(repeatedSequences2("AAAAAAAAAAA"));
    }

    private static List<String> repeatedSequences(String input) {
        Map<String, Integer> map = new HashMap<>();
        Set<String> output = new HashSet<>();
        for (int i = 0; i <= input.length() - 10 ; i++) {
            String subString = input.substring(i, i + 10);
            if (map.containsKey(subString)) {
                map.put(subString, map.get(subString) + 1);
                output.add(subString);
            } else
                map.put(subString, 1);
        }
        return new ArrayList<>(output);
    }


    private static List<String> repeatedSequences2(String input) {
        Set<String> uniqueList = new HashSet<>();
        Set<String> output = new HashSet<>();
        for (int i = 0; i <= input.length() - 10 ; i++) {
            String subString = input.substring(i, i + 10);
            if (uniqueList.contains(subString)) {
                output.add(subString);
            } else
                uniqueList.add(subString);
        }
        return new ArrayList<>(output);
    }
}

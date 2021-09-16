package com.algo.exercise.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    public static void main(String[] args) {
        System.out.println(findGroupAnagrams(new String[] {"eat", "tea", "tan", "eat", "ate", "nat", "bat"}));
    }

    private static List<List<String>> findGroupAnagrams(String[] arr) {
        Map<String, List<String>> result = new HashMap<>();
        if (arr.length == 0)
            return new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            char[] chars = arr[i].toCharArray();
            Arrays.sort(chars);
            String sortedString = String.valueOf(chars);
            if (result.containsKey(sortedString)) {
                if (!result.get(sortedString).contains(arr[i]))
                    result.get(sortedString).add(arr[i]);
            } else {
                List<String> list = new ArrayList<>();
                list.add(arr[i]);
                result.put(sortedString, list);
            }
        }
        return new ArrayList<>(result.values());
    }
}

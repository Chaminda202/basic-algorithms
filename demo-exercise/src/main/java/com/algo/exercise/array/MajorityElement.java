package com.algo.exercise.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class MajorityElement {
    public static void main(String[] args) {
        System.out.println(findMajorityElement(new int [] {2, 2, 1, 1, 2, 2}));
        System.out.println(findMajorityElementSecond(new int [] {2, 2, 1, 1, 2, 2}));
    }

    private static int findMajorityElement (int [] arr) {
        if (arr.length == 0)
            return 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                if (map.get(arr[i]) + 1 > arr.length / 2) {
                    return arr[i];
                }
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }
        return 0;
    }

    private static long findMajorityElementSecond (int [] arr) {
        if (arr.length == 0)
            return 0;
        // if list items are UNIQUE, we can use this way to convert array to list
        /*Map<Integer, Integer> map = Arrays.stream(arr).boxed()
                .collect(Collectors.toMap(Integer::intValue, Function.identity()));*/

        Map<Integer, Long> map = Arrays.stream(arr).boxed()
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()));

        Optional<Map.Entry<Integer, Long>> optionalEntry = map.entrySet().stream()
                .filter(k -> k.getValue() > arr.length / 2).findFirst();
        if (optionalEntry.isPresent())
            return optionalEntry.get().getKey();
        else
            return 0;
    }
}

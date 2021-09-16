package com.algo.exercise.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DiffPairsArray {
    public static void main(String[] args) {
        System.out.println(diffPairsArrayCount(new int[] {3, 1, 4, 1, 5}, 2));
        System.out.println(findDiffPairsArray(new int[] {3, 1, 4, 1, 5}, 2));
    }

    private static int diffPairsArrayCount(int [] arr, int diff) {
        int count = 0;
        Map<Integer, Long> map = Arrays.stream(arr).boxed()
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()));

        for (Map.Entry<Integer, Long> entry : map.entrySet()) {
            if (diff == 0 && entry.getValue() >= 2)
                count++;
            else if (map.containsKey(entry.getKey() + diff)) {
                count++;
            }
        }
        return count;
    }

    private static List<List<Integer>> findDiffPairsArray(int [] arr, int diff) {
        List<List<Integer>> pairs = new ArrayList<>();
        /*Map<Integer, List<Integer>> collect = Arrays.stream(arr).boxed()
                .collect(Collectors.groupingBy(e -> e));*/

        Map<Integer, Long> map = Arrays.stream(arr).boxed()
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()));

        for (Map.Entry<Integer, Long> entry : map.entrySet()) {
            List<Integer> pair = new ArrayList<>();
            if (diff == 0 && entry.getValue() >= 2){
                pair.add(entry.getKey());
                pair.add(entry.getKey());
                pairs.add(pair);
            }else if (map.containsKey(entry.getKey() + diff)){
                pair.add(entry.getKey());
                pair.add(entry.getKey() + diff);
                pairs.add(pair);
            }
        }
        return pairs;
    }
}

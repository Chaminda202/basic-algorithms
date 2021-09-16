package com.algo.exercise.string;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WordBreak {
    public static void main(String[] args) {
        System.out.println(checkWordBreak("codeleetcode", Arrays.asList("code", "leet")));
    }

    private static boolean checkWordBreak(String input, List<String> dictList) {
        boolean [] dyList = new boolean[input.length() + 1];
        dyList[0] = true;
        Set<String> distinctSet = dictList.stream().collect(Collectors.toSet());
        for (int i = 1; i <= input.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dyList[j] && distinctSet.contains(input.substring(j, i))) {
                    dyList[i] = true;
                    break;
                }
            }
        }
        return dyList[input.length()];
    }
}

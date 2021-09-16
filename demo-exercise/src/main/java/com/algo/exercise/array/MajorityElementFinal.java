package com.algo.exercise.array;

public class MajorityElementFinal {
    public static void main(String[] args) {
        System.out.println(findMajorityElement(new int [] {2, 2, 1, 1, 1, 2, 2}));
    }

    private static int findMajorityElement (int [] arr) {
        int count = 0, candidate = 0;
        if (arr.length == 0)
            return 0;
        for (int i = 0; i < arr.length; i++) {
            if (count == 0)
                candidate = arr[i];
            count += candidate == arr[i] ? 1 : -1;
        }
        return candidate;
    }
}

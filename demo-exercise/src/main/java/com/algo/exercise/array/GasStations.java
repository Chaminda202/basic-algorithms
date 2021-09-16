package com.algo.exercise.array;

public class GasStations {
    public static void main(String[] args) {
        System.out.println(findGasStation(new int [] {1, 2, 3, 4, 5}, new int [] {3, 4, 5, 1, 2}));
    }

    private static int findGasStation(int [] gas, int [] cost) {
        int pos = -1, current = 0, total = 0;
        for (int i = 0; i < gas.length; i++) {
            int diff = gas[i] - cost[i];
            current += diff;
            total += diff;

            if (current < 0) {
                current = 0;
                pos = i;
            }
        }
        if (total >= 0)
            return pos + 1;
        return -1;
    }
}

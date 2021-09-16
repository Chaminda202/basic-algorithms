package com.algo.exercise.array;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangleRow {
    public static void main(String[] args) {
        System.out.println(findPascalTriangleRow(4));
    }

    private static List<Integer> findPascalTriangleRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            row.add(1);
            for (int j = i - 1; j > 0 ; j--) {
                row.set(j, row.get(j -1) + row.get(j));
            }
        }
        return row;
    }
}

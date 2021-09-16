package com.algo.exercise.string;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class FizzBuzz {
    public static void main(String[] args) {
        System.out.println(checkFizzBuzz(5));
    }

    private static List<String> checkFizzBuzz(Integer max) {
        List<String> finalOutPut = new ArrayList<>();
        IntStream.rangeClosed(1, max).forEach(i -> {
            if (i % 3 == 0 && i % 5 == 0) {
                finalOutPut.add("FizzBuzz");
            } else if (i % 3 == 0) {
                finalOutPut.add("Fizz");
            } else if (i % 5 == 0) {
                finalOutPut.add("Fizz");
            } else
                finalOutPut.add(String.valueOf(i));
        });
        return finalOutPut;
    }
}

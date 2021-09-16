package com.algo.exercise.stream;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMap {
    public static void main(String[] args) {
        String[] arrayOfWords = {"STACK", "OOOVVVER"};
        Stream<String> streamOfWords = Arrays.stream(arrayOfWords);
        streamOfWords.map(s->s.split(""))    //Converting word in to array of letters
                .flatMap(Arrays::stream).distinct() //flattens each generated stream in to a single stream
                .collect(Collectors.toList());

    }
}

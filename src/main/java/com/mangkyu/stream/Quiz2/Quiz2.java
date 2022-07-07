package com.mangkyu.stream.Quiz2;

import java.util.*;
import java.util.stream.Collectors;

public class Quiz2 {

    private static List<String> WORDS = Arrays.asList("TONY", "a", "hULK", "B", "america", "X", "nebula", "Korea");

    public Map<String, Integer> quiz1() {
        return WORDS.stream()
                .map(w -> w.substring(0, 1))
                .collect(Collectors.toMap(
                        prefix -> prefix, prefix -> 1,
                        (oldValue, newValue) -> (newValue += oldValue)));
    }


    public String quiz2() {
        String trim = WORDS.stream()
                .filter(word -> word.length() >= 2)
                .map(cvtWord -> cvtWord.substring(0,1).toUpperCase())
                .collect(Collectors.joining(" "))
                .trim();


        return trim;
    }

}

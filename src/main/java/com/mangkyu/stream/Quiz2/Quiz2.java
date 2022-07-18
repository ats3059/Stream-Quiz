package com.mangkyu.stream.Quiz2;

import java.util.*;
import java.util.stream.Collectors;

public class Quiz2 {

    private static List<String> WORDS = Arrays.asList("TONY", "a", "hULK", "B", "america", "X", "nebula", "Korea");
    //toMap 에서 두번째 function은 같은 키일때 새로운 값으로 적용할 것인지 전에 있던 값으로 적용할 것인지 설정하는 것.
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

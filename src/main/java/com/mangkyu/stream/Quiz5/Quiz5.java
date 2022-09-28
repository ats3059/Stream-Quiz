package com.mangkyu.stream.Quiz5;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Quiz5 {

    private static final String[] STRING_ARR = {"aaa", "bb", "c", "dddd"};

    public int quiz1() {
        return Arrays.stream(STRING_ARR).mapToInt(str -> str.length()).sum();
    }

    public int quiz2() {
        return Arrays.stream(STRING_ARR).mapToInt(str -> str.length()).max().getAsInt();
    }

    public List<Integer> quiz3() {


        return Collections.emptyList();
    }

    public List<Integer[]> quiz4() {
        return Collections.emptyList();
    }


}

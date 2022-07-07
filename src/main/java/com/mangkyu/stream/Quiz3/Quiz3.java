package com.mangkyu.stream.Quiz3;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Quiz3 {

    private static final List<Integer> numbers1 = Arrays.asList(1, 2, 3);
    private static final List<Integer> numbers2 = Arrays.asList(3, 4);

    public List<Integer[]> quiz1() {
        return numbers1.stream()
                .flatMap(n -> numbers2.stream().map(m -> new Integer[]{n,m}))
                .collect(Collectors.toList());
    }

    public int quiz2() {
        return numbers1.stream()
                .flatMap(n -> numbers2.stream().map(m -> new Integer(n * m)))
                .max(Comparator.naturalOrder()).get();
    }

}

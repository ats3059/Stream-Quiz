package com.mangkyu.stream.Quiz1;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Quiz1 {

    public static void main(String[] args) throws IOException {
        Quiz1 quiz1 = new Quiz1();
        quiz1.quiz1();
    }

    public Map<String, Integer> quiz1() throws IOException {
        List<String[]> csvLines = readCsvLines();

        csvLines.forEach(s -> System.out.println(Arrays.toString(s)));

        Map<String, Integer> collect = csvLines.stream().map(strArr -> strArr[1].replaceAll("\\s", ""))
                .flatMap(str -> Arrays.stream(str.split(":")))
                .collect(Collectors.toMap(str -> str, str -> 1, (oldValue, newValue) -> oldValue + 1));
        return collect;
    }

    public Map<String, Integer> quiz2() throws IOException {
        List<String[]> csvLines = readCsvLines();

        Map<String, Integer> collect = csvLines.stream()
                .filter(strArr -> strArr[0].startsWith("정"))
                .map(strArr -> strArr[1].replaceAll("\\s", ""))
                .flatMap(str -> Arrays.stream(str.split(":")))
                .collect(
                        Collectors.toMap(str -> str, str -> 1, (oldValue, newValue) -> oldValue + 1)
                );
        return collect;
    }

    public int quiz3() throws IOException {
        List<String[]> csvLines = readCsvLines();
        int sum = csvLines.stream().mapToInt(strArr -> count(strArr[2])).sum();
        return sum;
    }

    private int count(String str) {
        int cnt = 0;
        int fromIndex = 0;
        for (int i = 0; i < str.length(); i++) {
            int indexCnt = str.indexOf("좋아", fromIndex);
            if (indexCnt > 0) {
                fromIndex = indexCnt + 2;
                cnt++;
            } else {
                return 0;
            }
        }
        return cnt;
    }

    private List<String[]> readCsvLines() throws IOException {
        CSVReader csvReader = new CSVReader(new FileReader(getClass().getResource("/user.csv").getFile()));
        csvReader.readNext();

        return csvReader.readAll();
    }


}

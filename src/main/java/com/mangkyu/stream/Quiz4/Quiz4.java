package com.mangkyu.stream.Quiz4;


import java.util.*;
import java.util.stream.Collectors;

public class Quiz4 {

    private List<Transaction> transactions;

    public Quiz4() {
        init();
    }

    private void init() {
        Trader kyu = new Trader("Kyu", "Seoul");
        Trader ming = new Trader("Ming", "Gyeonggi");
        Trader hyuk = new Trader("Hyuk", "Seoul");
        Trader hwan = new Trader("Hwan", "Busan");

        transactions = Arrays.asList(
                new Transaction(kyu, 2019, 30000),
                new Transaction(kyu, 2020, 12000),
                new Transaction(ming, 2020, 40000),
                new Transaction(ming, 2020, 7100),
                new Transaction(hyuk, 2019, 5900),
                new Transaction(hwan, 2020, 4900)
        );
    }

    public List<Transaction> quiz1() {

        return transactions.stream().filter(trade -> trade.getYear() == 2020)
                .sorted(Comparator.comparingInt(Transaction::getValue)).collect(Collectors.toList());
    }

    public List<String> quiz2()
    {
        return transactions.stream()
                .map(t -> t.getTrader().getCity()).distinct().collect(Collectors.toList());
    }

    public List<Trader> quiz3() {
        return transactions.stream()
                .filter(trade -> "Seoul".equals(trade.getTrader().getCity()))
                .map(Transaction::getTrader)
                .distinct()
                .sorted(Comparator.comparing(t -> t.getName()))
                .collect(Collectors.toList());
    }

    public String quiz4() {
        return transactions.stream()
                .map(trade -> trade.getTrader().getName())
                .distinct()
                .sorted()
                .collect(Collectors.joining(","));
    }

    public boolean quiz5() {
        return transactions.stream()
                .map(trade -> trade.getTrader().getCity())
                .anyMatch(trade -> "Busan".equals(trade));
    }

    public List<Integer> quiz6() {
        return transactions.stream()
                .filter(trade -> "Seoul".equals(trade.getTrader().getCity()))
                .map(Transaction::getValue)
                .collect(Collectors.toList());

    }

    public Integer[] quiz7() {
        Integer[] result = new Integer[2];
        int min = transactions.stream()
                .mapToInt(transaction -> transaction.getValue())
                .min().orElseThrow(NoSuchElementException::new);

        int max = transactions.stream()
                .mapToInt(Transaction::getValue)
                .reduce(Integer::max)
                .orElseThrow(NoSuchElementException::new);

        result[1] = min;
        result[0] = max;

        return result;
    }

}

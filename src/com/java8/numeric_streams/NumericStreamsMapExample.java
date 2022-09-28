package com.java8.numeric_streams;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

import static java.util.stream.Collectors.toList;

public class NumericStreamsMapExample {
    static class Pair {
        int a;
        int b;

        Pair(int x) {
            a = x;
            b = x*x;
        }
    }

    public static List<Pair> mapToObj() {
        return IntStream.rangeClosed(1, 5) // IntStream
                .mapToObj(Pair::new) // Converts IntStream -> Stream<Object>
                .collect(toList());
    }

    public static long mapToLong() {
        return IntStream.rangeClosed(1, 1000000) // IntStream
                .mapToLong(i->i) // Converts IntStream to LongStream
                .sum();
    }

    public static double mapToDouble() {
        return LongStream.rangeClosed(1, 100000) // IntStream
                .mapToDouble(i->i) // Converts IntStream to DoubleStream
                .sum();
    }

    public static void main(String[] args) {
        System.out.println("Result of mapToObj: " + mapToObj());

        System.out.println("Result of mapToLong: " + mapToLong());

        System.out.println("Result of mapToDouble: " + mapToDouble());
    }
}

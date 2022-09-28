package com.java8.numeric_streams;

import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class NumericStreamsRangeExample {

    public static void main(String[] args) {
        System.out.println("IntStream Range Count: " + IntStream.range(1,50).count());
        IntStream.range(1,50).forEach(x -> System.out.print(x + ", "));
        System.out.println();

        System.out.println("IntStream Range Closed Count: " + IntStream.rangeClosed(1,50).count());
        IntStream.rangeClosed(1,50).forEach(x -> System.out.print(x + ", "));
        System.out.println();

        System.out.println("LongStream Range Count: " + LongStream.range(1,50).count());
        LongStream.range(1,50).forEach(x -> System.out.print(x + ", "));
        System.out.println();

        System.out.println("LongStream Range Closed Count: " + LongStream.rangeClosed(1,50).count());
        LongStream.rangeClosed(1,50).forEach(x -> System.out.print(x + ", "));
        System.out.println();
        System.out.println();

        IntStream.rangeClosed(1, 50)
                .asDoubleStream().forEach(x-> System.out.print(x +", "));
    }
}

package com.java8.numeric_streams;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class NumericStreamsBoxingUnboxingExample {

    public static List<Integer> boxing() {
        return IntStream.rangeClosed(1, 20) // IntStream of 20 elements
                .boxed() // Converts int -> Integer
                .collect(toList());
    }

    public static int unboxing(List<Integer> integers) {
        return integers.stream()
                // mapToInt returns an IntStream
                .mapToInt(Integer::intValue) // Converts Integer -> int
                .sum();
    }

    public static void main(String[] args) {
        List<Integer> integers = boxing();

        System.out.println("List of Integers after boxing operation: " + integers);

        System.out.println("Sum of values after unboxing operation: " + unboxing(integers));
    }
}

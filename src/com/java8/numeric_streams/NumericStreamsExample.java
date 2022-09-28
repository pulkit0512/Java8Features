package com.java8.numeric_streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class NumericStreamsExample {

    public static int getSumOfNNumbers(List<Integer> integers) {
        // getting desired result, but here we are passing list of Integer, which is a wrapper class.
        // So java performs unboxing operation to convert Integer to int. Wasted Effort
        // Every time it unboxes the integer and performs summation
        return integers.stream()
                .reduce(0, Integer::sum);
    }

    public static int getSumOfNNumbersUsingIntStream() {
        return IntStream.rangeClosed(1, 6) // creates an IntStream having values 1, 2, 3, 4, 5, 6
                .sum();
    }

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6);
        System.out.println("Sum of integers: " + getSumOfNNumbers(integers));

        System.out.println("Sum of integers using IntStream: " + getSumOfNNumbersUsingIntStream());
    }
}

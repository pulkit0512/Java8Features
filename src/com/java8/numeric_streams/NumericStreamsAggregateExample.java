package com.java8.numeric_streams;

import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class NumericStreamsAggregateExample {

    public static void main(String[] args) {
        System.out.println("Sum of Integers: " + IntStream.rangeClosed(1, 50).sum());

        IntStream intStreamMax = IntStream.of(1, 5, -9, 38, -10, 2, 14, -3);
        IntStream intStreamMin = IntStream.of(1, 5, -9, 38, -10, 2, 14, -3);

        OptionalInt optionalIntMax = intStreamMax.max();
        System.out.println("Max Value is: " + (optionalIntMax.isPresent() ? optionalIntMax.getAsInt() : 0));

        OptionalInt optionalIntMin = intStreamMin.min();
        System.out.println("Min Value is: " + (optionalIntMin.isPresent() ? optionalIntMin.getAsInt() : 0));

        OptionalDouble optionalDouble = IntStream.rangeClosed(1, 50).average();
        System.out.println("Average Value is: " + (optionalDouble.isPresent() ? optionalDouble.getAsDouble() : 0));
    }
}

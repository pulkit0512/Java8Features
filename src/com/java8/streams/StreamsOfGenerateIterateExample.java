package com.java8.streams;

import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class StreamsOfGenerateIterateExample {

    public static void main(String[] args) {
        Stream<String> stringStream = Stream.of("Java", "Python", "C++", "Rust", "Swift");
        stringStream.forEach(System.out::println);

        // Takes initial value and a unary operator to perform function on given input
        // Creates a stream with initial value 1 as 1, 2, 4, 8, 16, ....
        Stream.iterate(1, x->x*2) // Creates an infinite stream, we can break it using limit function
                .limit(10)
                .forEach(System.out::println);

        // Takes a supplier as input and creates an infinite stream, here also we can break it using limit function
        Supplier<Integer> intSupplier = new Random()::nextInt;
        Stream.generate(intSupplier)
                .limit(5)
                .forEach(System.out::println);
    }
}

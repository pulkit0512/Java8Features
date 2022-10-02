package com.java8.streams_terminal;

import com.java8.data.StudentDatabase;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsCountingExample {

    public static long counting() {
        return StudentDatabase.getAllStudents()
                .stream()
                .filter(student -> student.getGpa()>=3.9)
                .collect(Collectors.counting());
    }
    public static void main(String[] args) {
        // Counting number of students using counting method
        System.out.println("Number of Students using counting() method: " + counting());


        // Same functionality can be achieved using count() method of stream()
        /*
        One difference is with the implementation. This is documented on Stream.count() (at least on versions 9+):
        An implementation may choose to not execute the stream pipeline (either sequentially or in parallel)
        if it is capable of computing the count directly from the stream source. In such cases no source elements will
        be traversed and no intermediate operations will be evaluated.
         */

        System.out.println(Stream.of(1, 2, 3, 4, 5)
                .map(i -> {
                    System.out.println("processing with count " + i);
                    return i * 2;
                }).count());

        System.out.println(Stream.of(1, 2, 3, 4, 5)
                .map(i -> {
                    System.out.println("processing with counting " + i);
                    return i * 2;
                }).collect(Collectors.counting())); // In trivial use cases, we can use count directly since it is also a terminal operation.
    }
}

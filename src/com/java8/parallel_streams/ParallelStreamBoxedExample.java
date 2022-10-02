package com.java8.parallel_streams;

import java.util.List;
import java.util.stream.LongStream;

import static java.util.stream.Collectors.toList;

public class ParallelStreamBoxedExample {

    public static long sequentialSum(List<Long> longList) {
        long start = System.currentTimeMillis();
        long sum = longList
                .stream()
                .reduce(0L, Long::sum);
        long end = System.currentTimeMillis();

        System.out.println("Sequential Duration: " + (end-start));
        return sum;
    }

    public static long parallelSum(List<Long> longList) {
        long start = System.currentTimeMillis();
        long sum = longList
                .parallelStream()
                .reduce(0L, Long::sum); // performs unboxing of Integer to int for each Integer
        long end = System.currentTimeMillis();

        System.out.println("Parallel Duration: " + (end-start));
        return sum;
    }

    public static void main(String[] args) {
        List<Long> longList = LongStream.rangeClosed(1, 100000)
                .boxed().collect(toList());

        System.out.println("Sequential Sum: " + sequentialSum(longList));

        System.out.println("Parallel Sum: " + parallelSum(longList));
    }
}

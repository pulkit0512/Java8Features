package com.java8.parallel_streams;

import java.util.function.LongSupplier;
import java.util.stream.LongStream;

public class ParallelStreamsExample {

    public static long checkPerformance(LongSupplier supplier, int numberOfTimes) {

        long startTime = System.currentTimeMillis();
        for(int i=0;i<numberOfTimes;i++){
            supplier.getAsLong();
        }
        long endTime = System.currentTimeMillis();

        return endTime - startTime;
    }

    public static long getSumSequentialStream() {
        return LongStream.rangeClosed(1, 10000000)
                .sum();
    }

    public static long getSumParallelStream() {
        // Number of threads created == number of processor available in the machine.
        return LongStream.rangeClosed(1, 10000000)
                .parallel() // splits data into multiple parts, and then assign each part of stream to a different processor
                // Each processor performs the sum concurrently and then in the end combine the result as the output.
                .sum();
    }

    public static void main(String[] args) {
        // For smaller set of data sequential stream is better to use then parallel stream.
        // As we move to larger data set benefits of parallel streams can be seen.
        System.out.println(Runtime.getRuntime().availableProcessors());

        System.out.println("Sequential Stream Sum: " + getSumSequentialStream());

        System.out.println("Parallel Stream Sum: " + getSumParallelStream());

        System.out.println("Sequential Stream Result in ms: " +
                checkPerformance(ParallelStreamsExample::getSumSequentialStream, 30));

        System.out.println("Parallel Stream Result in ms: " +
                checkPerformance(ParallelStreamsExample::getSumParallelStream, 30));
    }
}

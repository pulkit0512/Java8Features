package com.java8.parallel_streams;

import java.util.stream.IntStream;

public class SumClient {

    public static void main(String[] args) {
        Sum sum = new Sum();
        IntStream.rangeClosed(1, 1000)
                //1,2,3...1000
                .forEach(sum::performSum);
        System.out.println("Sequential sum: " + sum.getTotal());

        //In parallel sum, we get different answer each time we execute perform
        //this is because total is a mutable variable and different threads make changes to different value of total
        //Due to this in case of mutable variables don't use parallel streams.
        // Thread safety and synchronisation issues will come.
        Sum sumParallel = new Sum();
        IntStream.rangeClosed(1, 1000)
                .parallel()
                .forEach(sumParallel::performSum);
        System.out.println("Parallel sum: " + sumParallel.getTotal());
    }
}

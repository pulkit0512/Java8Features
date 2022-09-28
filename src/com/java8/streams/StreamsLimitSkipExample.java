package com.java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamsLimitSkipExample {

    public static Optional<Integer> getLimitSum(List<Integer> integers) {
        return integers.stream()
                // Limits the stream to first 5 elements. These 5 will go to reduce function
                // 2,5,3,4,-2
                .limit(5)
                .reduce(Integer::sum);
    }

    public static Optional<Integer> getSkipSum(List<Integer> integers) {
        return integers.stream()
                // Skips the stream for first 5 elements. These 5 will NOT go to reduce function
                // 2,5,3,4,-2
                .skip(5)
                .reduce(Integer::sum);
    }

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(2,5,3,4,-2,1,7,10,-6,8);

        Optional<Integer> limitSumOptional = getLimitSum(integers);

        limitSumOptional.ifPresent(sum -> System.out.println("Limit Sum is: " + sum));

        Optional<Integer> skipSumOptional = getSkipSum(integers);

        skipSumOptional.ifPresent(sum -> System.out.println("Skip Sum is: " + sum));
    }
}

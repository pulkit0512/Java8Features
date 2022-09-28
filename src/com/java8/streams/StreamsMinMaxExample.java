package com.java8.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamsMinMaxExample {
    private static final String EMPTY_LIST = "List is empty";

    public static int getMaxValue(List<Integer> integers) {
        return integers.stream()
                //max(a,b)
                // a holds max till now and b holds current value from stream
                .reduce(Integer.MIN_VALUE, Math::max);
    }

    public static Optional<Integer> getMaxValueOptional(List<Integer> integers) {
        return integers.stream()
                //max(a,b)
                // a holds max till now and b holds current value from stream
                .reduce(Math::max);
    }

    public static int getMinValue(List<Integer> integers) {
        return integers.stream()
                // min(a,b)
                // a holds min till now and b holds current value from stream
                .reduce(Integer.MAX_VALUE, Math::min);
    }

    public static Optional<Integer> getMinValueOptional(List<Integer> integers) {
        return integers.stream()
                // min(a,b)
                // a holds min till now and b holds current value from stream
                .reduce(Math::min);
    }

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(2,5,3,4,-2,1,7,10,-6,8);
        List<Integer> empty = new ArrayList<>();

        // MAX Operation
        System.out.println("Max Value in Integers: " + getMaxValue(integers));
        //In this case we get max value as Integer MIN_VALUE, but this is not correct since list is empty.
        //So here optional can help us. Or in identity we can pass Integer.MIN_VALUE/Integer.MAX_VALUE
        System.out.println("Max Value in Empty List: " + getMaxValue(empty));

        // In case of finding max/min, it's recommended to use Optional
        Optional<Integer> result1 = getMaxValueOptional(integers);
        Optional<Integer> result2 = getMaxValueOptional(empty);
        System.out.println(result1+", "+result2);

        if(result1.isPresent()) {
            System.out.println("Max Value using Optional is: " + result1.get());
        }else{
            System.out.println(EMPTY_LIST);
        }

        if(result2.isPresent()) {
            System.out.println("Max Value using Optional is: " + result2.get());
        }else{
            // Now for empty list we are getting correct information
            System.out.println(EMPTY_LIST);
        }


        // MIN Operation
        System.out.println("Min Value in Integers: " + getMinValue(integers));
        //In this case we get min value as Integer MAX_VALUE, but this is not correct since list is empty.
        //So here optional can help us. Or in identity we can pass Integer.MIN_VALUE/Integer.MAX_VALUE
        System.out.println("Min Value in Empty List: " + getMinValue(empty));

        // In case of finding max/min, it's recommended to use Optional
        Optional<Integer> result3 = getMinValueOptional(integers);
        Optional<Integer> result4 = getMinValueOptional(empty);
        System.out.println(result3+", "+result4);

        if(result3.isPresent()) {
            System.out.println("Min Value using Optional is: " + result3.get());
        }else{
            System.out.println(EMPTY_LIST);
        }

        if(result4.isPresent()) {
            System.out.println("Min Value using Optional is: " + result4.get());
        }else{
            // Now for empty list we are getting correct information
            System.out.println(EMPTY_LIST);
        }
    }
}

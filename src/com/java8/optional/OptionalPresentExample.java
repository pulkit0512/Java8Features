package com.java8.optional;

import java.util.Optional;

public class OptionalPresentExample {

    public static void testOptionalPresent(String input) {
        Optional<String> optional = Optional.ofNullable(input);
        System.out.println(optional.isPresent());

        //In case, we need to perform different operations based on if optional contains a value or not.
        //Then use optional.isPresent()
        if(optional.isPresent()) {
            System.out.println(optional.get());
        }else{
            System.out.println("Null value");
        }

        //In case, we need to perform operation, only when value is present in optional
        // then better to use optional.ifPresent(), takes a consumer as input
        optional.ifPresent(System.out::println);
    }

    public static void main(String[] args) {
        testOptionalPresent("hello Optional");
        System.out.println();
        testOptionalPresent(null);
    }
}

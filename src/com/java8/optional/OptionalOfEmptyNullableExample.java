package com.java8.optional;

import java.util.Optional;

public class OptionalOfEmptyNullableExample {

    //Use this in case, when we are not sure whether the input to Optional is null or non-null.
    //Since this can accept both null and non-null values.
    public static Optional<String> ofNullable() {
        //return Optional.ofNullable(null);
        return Optional.ofNullable("Hello");
    }

    //Use this in case, when we are sure the input to Optional will always non-null.
    //In case of null input it will give null pointer error.
    public static Optional<String> of() {
        return Optional.of("Hello");
    }

    //Use this when we need an empty optional, such as in case of catch blocks we can return empty optional to
    // adhere to the return type of the function and hence no breaking of code.
    public static Optional<String> empty() {
        return Optional.empty();
    }
    public static void main(String[] args) {
        System.out.println("OfNullable: " + ofNullable());
        System.out.println("Of: " + of());
        System.out.println("Empty: " + empty());
    }
}

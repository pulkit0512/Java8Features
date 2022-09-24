package com.java8.functional_interfaces;

import java.util.function.UnaryOperator;

public class UnaryOperatorExample {

    // This Unary Operator takes String as input and returns a string as output.
    // whenever have a use case with the input and output of the same type in those cases,
    // we don't even have to use a function. We can use unary operator those use cases.
    static UnaryOperator<String> unaryOperator = s -> s.concat(" Unary Operator");

    public static void main(String[] args) {
        System.out.println("Unary Operator Result: " + unaryOperator.apply("Java8"));
    }
}

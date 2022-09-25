package com.java8.method_constructor_reference;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class FunctionMethodReferenceExample {

    static Function<String, String> lambdaFunction = str -> str.toUpperCase();

    // We can use Unary Operator instead of Function, since both input and output types are same.
    static UnaryOperator<String> lambdaUnary = str -> str.toUpperCase();

    // Simpler way to write lambda functions
    static UnaryOperator<String> methodReferenceFunction = String::toUpperCase;


    public static void main(String[] args) {
        System.out.println("LambdaFunction Result: " + lambdaFunction.apply("Hello World with Function!!"));

        System.out.println("LambdaUnary Result: " + lambdaUnary.apply("Hello World with Unary Operator!!"));

        System.out.println("MethodReferenceFunction Result: " + methodReferenceFunction.apply("Hello World with Method Reference!!"));
    }
}

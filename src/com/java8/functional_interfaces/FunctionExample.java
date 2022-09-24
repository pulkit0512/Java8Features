package com.java8.functional_interfaces;

import java.util.function.Function;

public class FunctionExample {

    static Function<String, String> function = name -> name.toUpperCase();
    static Function<String, String> addSomeString = str -> str.concat(" Default");
    static Function<String, String> addSomeStringAgain = str -> str.concat(" Chaining");

    public static void main(String[] args) {
        String input = "Hello";

        // Applies assigned function to the input.
        // Here converts input string to uppercase.
        System.out.println("Result of function is: " + function.apply(input));

        // First applies the outer function to the input
        // and then applies the function passed as parameter to the andThen method.
        // Here first convert input to uppercase and then concat the given string to the output of first function.
        System.out.println("Result of andThen default function is: " + function.andThen(addSomeString).apply(input));

        // First applies the inner function passed as parameter to the compose method.
        // and then applies the outer function.
        // Here first concat the given String to input and then converts the entire string to uppercase.
        // Output of function passed as parameter of compose function acts as input of outer function.
        System.out.println("Result of compose default function is: " + function.compose(addSomeString).apply(input));

        // Function chaining, control moves from right to left.
        // For below case, first apply executes and takes input
        // then compose executes since it first execute parameter function so concat the passed string to input
        // then andThen executes since it first execute caller function so converts input to upper case string
        // and then execute function passed as parameter to andThen method,
        // i.e. concat given string to output of caller function.
        System.out.println("Result of Function Chaining: " + function
                .andThen(addSomeStringAgain)
                .compose(addSomeString)
                .apply(input));
    }
}

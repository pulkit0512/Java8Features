package com.java8.functional_interfaces;

import java.util.function.IntPredicate;
import java.util.function.Predicate;

public class PredicateExample {

    // We might wonder this is easily achievable using if-else.
    // But the benefit of using this as predicate is code re-usability. We can use same predicate function any number
    // of times throughout the project.
    // Assigning a function to a variable, can be passed to other functions as well.
    static Predicate<Integer> p1 = i -> i%2==0; // predicate to check divisible by 2.
    static Predicate<Integer> p2 = i -> i%5==0; // predicate to check divisible by 5.

    // If we have predefined existing java objects, java.util.functional package have specific functional classes.
    // We can use them directly.
    // Primitive Predicate Example
    static IntPredicate p = i -> i%3==0;

    public static void main(String[] args) {
        System.out.println("Primitive Int Predicate Result: " + p.test(4));

        System.out.println("Primitive Int Predicate Result: " + p.test(9));

        predicateAnd();
        predicateOr();
        predicateNegate();
    }

    public static void predicateAnd() {
        System.out.println("Predicate AND result for 10: " + p1.and(p2).test(10)); // Predicate Chaining
        System.out.println("Predicate AND result for 9: " + p1.and(p2).test(9));
        System.out.println("Predicate AND result for 8: " + p1.and(p2).test(8));
    }

    public static void predicateOr() {
        System.out.println("Predicate OR result for 10: " + p1.or(p2).test(10)); // Predicate Chaining
        System.out.println("Predicate OR result for 9: " + p1.or(p2).test(9));
        System.out.println("Predicate OR result for 8: " + p1.or(p2).test(8));
    }

    public static void predicateNegate() {
        System.out.println("Predicate NEGATE result for 8: " + p1.or(p2).negate().test(8)); // Predicate Chaining
    }
}

package com.java8.functional_interfaces;

import java.util.Comparator;
import java.util.function.BinaryOperator;
import java.util.function.IntBinaryOperator;

public class BinaryOperatorExample {

    public static void main(String[] args) {

        // Takes to integer as input and returns there multiplication as integer.
        BinaryOperator<Integer> binaryOperator = (a,b) -> a*b;

        Comparator<Integer> comparator = Comparator.naturalOrder();

        System.out.println("Binary Operator Result: " + binaryOperator.apply(5, 9));

        // We can also use primitive binary operator in case of primitive data types.
        IntBinaryOperator intBinaryOperator = (a,b) -> a/b;
        System.out.println("Int Binary Operator result: " + intBinaryOperator.applyAsInt(10, 5));

        BinaryOperator<Integer> maxBy = BinaryOperator.maxBy(comparator);
        System.out.println("Max By Result is: " + maxBy.apply(4,5));

        BinaryOperator<Integer> minBy = BinaryOperator.minBy(comparator);
        System.out.println("Min By Result is: " + minBy.apply(4,5));
    }
}

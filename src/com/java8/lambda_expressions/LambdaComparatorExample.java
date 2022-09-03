package com.java8.lambda_expressions;

import java.util.Comparator;

public class LambdaComparatorExample {

    public static void main(String[] args) {
        // Prior to Java 8
        Comparator<Integer> oldComparator = new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2); // 0 -> o1==o2, 1 -> o1>o2, -1 -> o1<o2
            }
        };

        System.out.println("Comparator using old Java: " + oldComparator.compare(3, 2));

        // Using Java 8 Lambda
        Comparator<Integer> newComparator = (Integer o1, Integer o2) -> o2.compareTo(o1);
        System.out.println(newComparator.compare(4, 3));

        // We don't need to explicitly pass the Data type of objects. Lambda is smart enough to convert objects to right
        // data types.
        // Concise and clear code.

        Comparator<Integer> newComparator1 = (o1, o2) -> o1.compareTo(o2);
        System.out.println(newComparator1.compare(4,5));
    }
}

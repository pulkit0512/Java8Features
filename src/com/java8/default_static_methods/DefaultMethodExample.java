package com.java8.default_static_methods;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DefaultMethodExample {

    public static void main(String[] args) {
        /*
        Prior to Java 8
         */

        List<String> namesList = Arrays.asList("Jenny", "Adam", "Mike", "Harry", "Ron", "Alex");
        Collections.sort(namesList);
        System.out.println("Names List sorted using Collections.sort() : " + namesList);

        Collections.sort(namesList, Collections.reverseOrder());
        System.out.println("Names List sorted using Collections.sort() reversed : " + namesList);

        /*
        With Java 8
         */

        List<String> namesList2 = Arrays.asList("Jenny", "Adam", "Mike", "Harry", "Ron", "Alex");

        namesList2.sort(Comparator.naturalOrder());
        System.out.println("Names List sorted using List.sort() : " + namesList2);

        namesList2.sort(Comparator.reverseOrder());
        System.out.println("Names List sorted using List.sort() reversed : " + namesList2);
    }
}

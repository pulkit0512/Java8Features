package com.java8.imperative_vs_declarative;

import java.util.*;
import java.util.stream.Collectors;

public class ImperativeVsDeclarativeExample2 {

    // Remove duplicates from list of integers
    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(1,2,3,3,4,5,5,9,9,7,8,6,2,3,6);
        /*
        Imperative Style: How Style of programming
         */
        Set<Integer> uniqueSet = new LinkedHashSet<>(integerList);

        List<Integer> uniqueListImperative = new ArrayList<>(uniqueSet);

        System.out.println("Unique List using Imperative Approach: " + uniqueListImperative);

        /*
        Declarative Style: What Style of programming
        Basically we are not going to write the logic on how to find the uniqueness.
        We are going to make use of the functions that are already present as part of the Java8.
        We just have to find the right function and then use it.

        Take a look at the code readability wise here we are just calling some functions we
        don't worry about how it is implemented. The system or the functions that got released as part of the language.
        It takes care of performing the operation that you requested, and it gives you the result.
        So this is one of the advantage of the declarative programming. We just call the appropriate functions
        based on use case, and it is going to perform the work and give the result that we are looking for.
         */

        List<Integer> uniqueListDeclarative = integerList.stream().distinct().collect(Collectors.toList());

        System.out.println("Unique List using Declarative Approach: " + uniqueListDeclarative);
    }
}

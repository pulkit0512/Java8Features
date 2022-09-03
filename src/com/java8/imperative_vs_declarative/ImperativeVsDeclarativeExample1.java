package com.java8.imperative_vs_declarative;

import java.util.stream.IntStream;

public class ImperativeVsDeclarativeExample1 {

    // Sum of first 100 numbers
    public static void main(String[]  args) {
        /*
        Imperative Style: How Style of programming
        Focuses on how it is done, we created a sumImperative mutable variable and by using external iteration
        made changes in the value of sumImperative value to achieve the final sum.
        Since we are using a mutable variable, in multi-threaded environment it can cause problems, and we may get
        unexpected results.
        And on the code readability perspective you need to go through the code line by line in order to understand what
        is happening.
        */
        int sumImperative = 0;
        for(int i=0;i<=100;i++) {
            sumImperative += i;
        }

        System.out.println("Sum Using Imperative Approach: " + sumImperative);

        /*
        Declarative Style: What Style of programming.
        Focus on what we need, and don't bother about how it is done.
        IntStream is an inbuilt class that will perform an internal iteration over the given range and when we call
        sum on the range we get the result what we need, and we don't bother on how it performed the sum.
        Here we haven't changed the value of sumDeclarative, and this will work well in multi-threaded environment as well.
        */

        int sumDeclarative = IntStream.rangeClosed(0, 100)
                                .sum();

        System.out.println("Sum Using Declarative Approach: " + sumDeclarative);
    }
}

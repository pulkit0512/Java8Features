package com.java8.lambda_expressions;

import java.util.function.IntConsumer;

public class LambdaVariableRestriction {

    static int value = 4; // Class variable. No restrictions in lambda for class and instance variables.

    public static void main(String[] args) {
        int i = 1; // Local Variable

        // Gives error value i is already defined in the scope.
        //Consumer<Integer> c1 = i -> System.out.println("Value is: " + i);

        IntConsumer c2 = a -> {
            //i = 2; We cannot reassign local variable inside lambda expression
            // Variable used in Lambda should be final or effectively final.
            // It acts as effective final for lambda expression.
            value++;
            System.out.println("Value is: " + (i+a+value));
        };

        // Since this is a local variable and used inside a lambda we can't reassign it.
        // It will give error in lambda
        //i = 7;

        // We are allowed to change the value of class/instance variable.
        value++;

        c2.accept(5);
        c2.accept(6);
    }
}

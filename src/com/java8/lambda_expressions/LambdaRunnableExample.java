package com.java8.lambda_expressions;

public class LambdaRunnableExample {

    public static void main(String[] args) {
        // Runnable is a functional interface
        // Optional Annotation @FunctionalInterface, used to determine whether an interface is functional or not.
        Runnable runnable = new Runnable() {
            public void run() {
                System.out.println("Runnable with prior to Java 8 using anonymous class");
            }
        };

        new Thread(runnable).start();

        // Using Java 8 Lambdas
        // Lot of boilerplate code to create instance of Functional interface is removed using lambdas.
        // No need to create anonymous classes.
        // Single line lambdas don't need curly braces.
        // Code readable and concise as compared to above approach.
        Runnable runnableLambdaSingleStatement = () -> System.out.println("Runnable using Lambda with Java 8");

        new Thread(runnableLambdaSingleStatement).start();

        Runnable runnableLambdaMultiStatement = () -> {
            System.out.println("Runnable one using Lambda with Java 8");
            System.out.println("Runnable two using Lambda with Java 8");
        };

        new Thread(runnableLambdaMultiStatement).start();

        Runnable runnableLambdaMultiToSingleStatement = () -> printStatements();

        new Thread(runnableLambdaMultiToSingleStatement).start();


        // Without passing reference of runnable to thread.
        new Thread(() -> System.out.println("Runnable Implementation!!")).start();

        // Prior to Java 8
        // not clear, clumsy implementation
        new Thread(new Runnable(){
            public void run() {
                System.out.println("Inside Runnable anonymous class");
            }
        }).start();
    }

    private static void printStatements() {
        System.out.println("Multi statement Runnable using Lambda with Java 8");
        System.out.println("Multi statement converted to single statement");
    }
}

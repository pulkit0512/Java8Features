package com.java8.streams;

import com.java8.data.StudentDatabase;

public class StreamsMatchExample {

    public static boolean allMatch() {
        return StudentDatabase.getAllStudents().stream()
                .allMatch(student -> student.getGpa()>=3.9);
    }

    public static boolean anyMatch() {
        return StudentDatabase.getAllStudents().stream()
                .anyMatch(student -> student.getGpa()>=3.9);
    }

    public static boolean noneMatch() {
        return StudentDatabase.getAllStudents().stream()
                .noneMatch(student -> student.getGpa()<=3.0);
    }

    public static void main(String[] args) {
        System.out.println("Result of allMatch: " + allMatch());
        System.out.println("Result of anyMatch: " + anyMatch());
        System.out.println("Result of noneMatch: " + noneMatch());
    }
}

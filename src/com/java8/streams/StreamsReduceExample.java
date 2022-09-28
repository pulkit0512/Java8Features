package com.java8.streams;

import com.java8.data.Student;
import com.java8.data.StudentDatabase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamsReduceExample {

    public static int performMultiplication(List<Integer> integers) {
        return integers.stream()
                // a = 1(identity), b = 1; result = 1 returned
                // a = 1(prevResult), b = 3; result 3 returned
                // a = 3(prevResult), b = 5; result 15 returned
                // a = 15(prevResult), b = 7; result 105 is returned
                // a=105(prevResult), b = 9; result 945 is returned
                .reduce(1, (a,b)->a*b);
    }

    // In this case reduce() returns Optional of Integer
    // To handle null values gracefully.
    public static Optional<Integer> performMultiplicationWithoutIdentity(List<Integer> integers) {
        return integers.stream()
                .reduce((a,b)->a*b);
    }

    // To get the student with highest GPA from stream students.
    public static Optional<Student> getStudentWithMaxGpa() {
        return StudentDatabase.getAllStudents().stream()
                .reduce((s1, s2) -> (s1.getGpa() >= s2.getGpa()) ? s1 : s2);
    }

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1,3,5,7,9);
        System.out.println(performMultiplication(integers));

        Optional<Integer> result = performMultiplicationWithoutIdentity(integers);

        result.ifPresent(product -> System.out.println("Multiplication Value: " + product));

        Optional<Integer> result1 = performMultiplicationWithoutIdentity(new ArrayList<>());

        // Will now print since list is empty, it will return null.
        // Always use get after checking isPresent, else we will get NoSuchElementException
        result1.ifPresent(product -> System.out.println("Value: " + product));

        Optional<Student> maxGpaStudent = getStudentWithMaxGpa();
        maxGpaStudent.ifPresent(System.out::println);
    }
}

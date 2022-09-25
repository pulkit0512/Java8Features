package com.java8.functional_interfaces;

import com.java8.data.Student;
import com.java8.data.StudentDatabase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public class BiFunctionExample {

    // BiFunction takes two input and produces an output.
    // In this example we pass a Predicate Functional Interface as a input parameter to BiFunction.
    // This is possible through Java8 and Lambda we are able to pass Functional Interfaces as input parameters to other methods.
    static BiFunction<List<Student>, Predicate<Student>, Map<String, Double>> biFunction = ((students, studentPredicate) -> {
        Map<String, Double> studentMap = new HashMap<>();

        students.forEach(student -> {
            if(studentPredicate.test(student)) {
                studentMap.put(student.getName(), student.getGpa());
            }
        });

        return studentMap;
    });

    static Function<Map<String, Double>, Integer> functionSquare = studentMap -> studentMap.size() * studentMap.size();

    public static void main(String[] args) {
        List<Student> studentList = StudentDatabase.getAllStudents();
        System.out.println("Result of BiFunction which takes predicate as input variable: "
                + biFunction.apply(studentList, PredicateStudentExample.gradeLevelPredicate));

        System.out.println("Result of BiFunction with other predicate if requirement changes with Function Chaining: "
                + biFunction.andThen(functionSquare).apply(studentList, PredicateStudentExample.gpaPredicate));
    }
}

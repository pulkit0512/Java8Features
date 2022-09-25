package com.java8.functional_interfaces;

import com.java8.data.Student;
import com.java8.data.StudentDatabase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class FunctionStudentExample {

    static Function<List<Student>, Map<String, Double>> studentFunction = (students -> {
            Map<String, Double> studentMap = new HashMap<>();
            students.forEach(student -> studentMap.put(student.getName(), student.getGpa()));
            return studentMap;
    });

    // New Requirement to add some conditions to the logic.
    // We can use existing predicate, here we need only those students now whose grade level >=3
    // In predicate example we have a predicate assigned to a variable for the same thing.
    // We can use it here now. Here Lambda and Java8 helps to achieve code re-usability.
    static Function<List<Student>, Map<String, Double>> studentFunctionWithPredicate = (students -> {
        Map<String, Double> studentMap = new HashMap<>();
        students.forEach(student -> {
            if(PredicateStudentExample.gradeLevelPredicate.test(student)) {
                studentMap.put(student.getName(), student.getGpa());
            }
        });
        return studentMap;
    });

    public static void main(String[] args) {
        List<Student> studentList = StudentDatabase.getAllStudents();

        System.out.println("Student Function Result: " + studentFunction.apply(studentList));

        System.out.println("Student Function with Predicate Result: " + studentFunctionWithPredicate.apply(studentList));
    }
}

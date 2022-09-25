package com.java8.streams;

import com.java8.data.Student;
import com.java8.data.StudentDatabase;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamsMapExample {

    public static void main(String[] args) {
        // Sequential name order in list
        System.out.println("Student Names: " + getStudentNames());

        // Random student names order in set
        System.out.println("Student Names in Set: " + getStudentNamesInSet());
    }

    private static List<String> getStudentNames() {

        return StudentDatabase.getAllStudents().stream() // Stream<Student>
                // map takes Function as input
                // Function has Student as an input -> Student Name
                .map(Student::getName) // Stream<String> // Converts one Stream type to another
                .map(String::toUpperCase) // Stream<String> -> uppercase operation on each input // Transforms the Stream
                .collect(Collectors.toList());// List<String>
    }

    private static Set<String> getStudentNamesInSet() {

        return StudentDatabase.getAllStudents().stream() // Stream<Student>
                // map takes Function as input
                // Function has Student as an input -> Student Name
                .map(Student::getName) // Stream<String> // Converts one Stream type to another
                .map(String::toUpperCase) // Stream<String> -> uppercase operation on each input // Transforms the Stream
                .collect(Collectors.toSet());// Set<String>
    }
}

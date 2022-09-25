package com.java8.streams;

import com.java8.data.Student;
import com.java8.data.StudentDatabase;
import com.java8.functional_interfaces.PredicateStudentExample;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamsExample {
    public static void main(String[] args) {
        // Create a map from student list, which has student name as key, and it's list of activities as value
        // First create stream on the List Collection
        // Collect from stream to a collectors as Map
        // toMap takes two input as Function Functional Interface
        // first Function creates the key and second is used to create the value for key in map.

        // In BiFunction example, we created a Map for student name vs corresponding gpa
        // Comparing that code with this, number of lines of code and how descriptive and readable this code is.
        Map<String, List<String>> studentMap = StudentDatabase.getAllStudents().stream()
                .collect(Collectors.toMap(Student::getName, Student::getActivities));

        System.out.println("Student Map using Stream size: " + studentMap.size());
        System.out.println("Student Map using Stream: " + studentMap);

        // Use case is to apply filter to have only those students in map whose grade level is >=3.
        // Filter takes Predicate as Input
        // To create parallel streams to do processing, we can use parallelStream instead of stream.
        // Declarative way of programming just asked for desired result and using existing functions of Streams API
        // we get the desired result.
        // We don't bother how filter works on this predicate to give desired result.
        Map<String, List<String>> studentMapWithFilter = StudentDatabase.getAllStudents().parallelStream()
                .filter(PredicateStudentExample.gradeLevelPredicate)
                .collect(Collectors.toMap(Student::getName, Student::getActivities));

        System.out.println("Student Map using Stream and Filter size: " + studentMapWithFilter.size());
        System.out.println("Student Map using Stream and Filter: " + studentMapWithFilter);

        // Use case is to apply filter to have only those students in map whose grade level is >=3 and gpa>=3.9
        // Filter takes Predicate as Input
        Map<String, List<String>> studentMapWithTwoFilters = StudentDatabase.getAllStudents().stream() // Stream<Student>
                .filter(PredicateStudentExample.gradeLevelPredicate) // filtered Stream<Student>
                .filter(PredicateStudentExample.gpaPredicate) // filter Stream<Student>
                .collect(Collectors.toMap(Student::getName, Student::getActivities)); // Map

        System.out.println("Student Map using Stream and 2 Filters size: " + studentMapWithTwoFilters.size());
        System.out.println("Student Map using Stream and 2 Filters: " + studentMapWithTwoFilters);
    }
}

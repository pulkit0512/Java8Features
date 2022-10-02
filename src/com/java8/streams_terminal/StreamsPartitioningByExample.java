package com.java8.streams_terminal;

import com.java8.data.Student;
import com.java8.data.StudentDatabase;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamsPartitioningByExample {

    public static void partitioningBy1() {
        Predicate<Student> gpaPredicate = student -> student.getGpa()>=3.8;

        Map<Boolean, List<Student>> studentMap = StudentDatabase.getAllStudents()
                .stream().collect(Collectors.partitioningBy(gpaPredicate));

        studentMap.forEach((k, v) -> System.out.println(k +" "+ v));
    }

    public static void partitioningBy2() {
        Predicate<Student> gpaPredicate = student -> student.getGpa()>=3.8;

        // By Default value type of partitioningBy map is List, we can change it by specifying the required collection type.
        // Here we collect output values in a set, and we can verify it by seeing the output.
        // Set doesn't preserve the order of insertion whereas List does.
        Map<Boolean, Set<Student>> studentMap = StudentDatabase.getAllStudents()
                .stream().collect(Collectors.partitioningBy(gpaPredicate, Collectors.toSet()));

        studentMap.forEach((k, v) -> System.out.println(k +" "+ v));
    }

    public static void partitioningBy3() {
        Predicate<Student> gpaPredicate = student -> student.getGpa()>=3.8;

        Map<Boolean, Map<String, List<String>>> studentMap = StudentDatabase.getAllStudents()
                .stream().collect(Collectors.partitioningBy(gpaPredicate,
                        Collectors.toMap(Student::getName, Student::getActivities)));

        studentMap.forEach((k, v) -> System.out.println(k +" "+ v));
    }

    public static void main(String[] args) {
        partitioningBy1();

        System.out.println();

        partitioningBy2();

        System.out.println();

        partitioningBy3();
    }
}

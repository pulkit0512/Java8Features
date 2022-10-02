package com.java8.streams_terminal;

import com.java8.data.Student;
import com.java8.data.StudentDatabase;

import java.util.*;
import java.util.stream.Collectors;

public class StreamsGroupingByExample {

    // Groups students based on gender
    public static void groupStudentsByGender() {
        Map<String, List<Student>> studentMap = StudentDatabase.getAllStudents()
                .stream().collect(Collectors.groupingBy(Student::getGender));

        studentMap.forEach((k, v) -> System.out.println(k.toUpperCase()+ " : " + v));
    }

    // Groups students based on GPA>=3.8 or not
    // Students with GPA>=3.8 are added to OUTSTANDING key list whereas others were added to AVERAGE key list.
    public static void customizedGroupByOnGPA() {
        Map<String, List<Student>> studentMap = StudentDatabase.getAllStudents()
                .stream().collect(Collectors.groupingBy(student -> student.getGpa()>=3.8 ? "OUTSTANDING" : "AVERAGE"));

        studentMap.forEach((k, v) -> System.out.println(k.toUpperCase()+ " : " + v));
    }

    //Groups students first on the grade level and then on basis of GPA>=3.8 or not into "OUTSTANDING"/"AVERAGE" categories.
    public static void twoLevelGrouping1() {
        Map<Integer, Map<String, List<Student>>> studentMap = StudentDatabase.getAllStudents()
                .stream().collect(Collectors.groupingBy(Student::getGradeLevel,
                        Collectors.groupingBy(student -> student.getGpa()>=3.8 ? "OUTSTANDING" : "AVERAGE")));

        studentMap.forEach((k, v) -> System.out.println(k +" : "+ v));
    }

    //Groups students first on the grade level and then sum the total number of books students have in that grade.
    public static void twoLevelGrouping2() {
        List<Student> students = StudentDatabase.getAllStudents();
        students.forEach(student -> student.setNoOfNotebooks(5 * student.getGradeLevel()));

        Map<Integer, Integer> studentMap = students.stream()
                .collect(Collectors.groupingBy(Student::getGradeLevel, Collectors.summingInt(Student::getNoOfNotebooks)));

        studentMap.forEach((k, v) -> System.out.println(k +" : "+ v));
    }

    // Two argument version internally calls the three argument version, by passing an addition parameter
    // which is a Supplier (new instance of HashMap), So that's why for above two versions of groupingBy output is
    // always a HashMap. We can change the output type of groupingBy to a different type of Map by overriding this version
    // and specify the output collection type which we need.
    public static void threeArgumentVersionOfGroupingBy() {
        //LinkedHashMap preserves the order of insertion in map.
        LinkedHashMap<String, Set<Student>> studentMap = StudentDatabase.getAllStudents().stream()
                // first parameter specifies the key, second parameter specifies output collection type
                // and third parameter specifies output type of values
                .collect(Collectors.groupingBy(Student::getName, LinkedHashMap::new, Collectors.toSet()));

        System.out.println(studentMap);
    }

    public static void getTopGpaStudentForEachGrade() {
        Map<Integer, Optional<Student>> studentMapOptional = StudentDatabase.getAllStudents()
                .stream()
                .collect(Collectors.groupingBy(Student::getGradeLevel,
                        Collectors.maxBy(Comparator.comparingDouble(Student::getGpa))));

        // This map has a value as Optional of Student, since Comparator.comparing returns Optional
        studentMapOptional.forEach((k, v) -> System.out.println(k +" : "+ v));

        System.out.println();
        System.out.println();

        // To get student directly instead of optional we have a method collectingAndThen
        Map<Integer, Student> studentMap = StudentDatabase.getAllStudents()
                .stream()
                .collect(Collectors.groupingBy(Student::getGradeLevel,
                        Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingDouble(Student::getGpa)),
                                Optional::get)));

        studentMap.forEach((k, v) -> System.out.println(k +" : " + v));
    }

    public static void getLeastGpaStudentForEachGrade() {
        Map<Integer, Optional<Student>> studentMapOptional = StudentDatabase.getAllStudents()
                .stream()
                .collect(Collectors.groupingBy(Student::getGradeLevel,
                        Collectors.minBy(Comparator.comparingDouble(Student::getGpa))));

        // This map has a value as Optional of Student, since Comparator.comparing returns Optional
        studentMapOptional.forEach((k, v) -> System.out.println(k +" : "+ v));

        System.out.println();
        System.out.println();

        // To get student directly instead of optional we have a method collectingAndThen
        Map<Integer, Student> studentMap = StudentDatabase.getAllStudents()
                .stream()
                .collect(Collectors.groupingBy(Student::getGradeLevel,
                        Collectors.collectingAndThen(Collectors.minBy(Comparator.comparingDouble(Student::getGpa)),
                                Optional::get)));

        studentMap.forEach((k, v) -> System.out.println(k +" : " + v));
    }

    public static void main(String[] args) {
        groupStudentsByGender();

        System.out.println();

        customizedGroupByOnGPA();

        System.out.println();

        twoLevelGrouping1();

        System.out.println();

        twoLevelGrouping2();

        System.out.println();

        threeArgumentVersionOfGroupingBy();

        System.out.println();

        getTopGpaStudentForEachGrade();

        System.out.println();

        getLeastGpaStudentForEachGrade();
    }
}

package com.java8.streams;

import com.java8.data.Student;
import com.java8.data.StudentDatabase;

import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class StreamsComparatorExample {

    public static List<Student> getStudentSortedByName() {
        return StudentDatabase.getAllStudents()
                .stream()
                .sorted(Comparator.comparing(Student::getName))
                .collect(toList());
    }

    public static List<Student> getStudentSortedByGpa() {
        return StudentDatabase.getAllStudents()
                .stream()
                .sorted(Comparator.comparing(Student::getGpa))
                .collect(toList());
    }

    public static List<Student> getStudentSortedByGpaDesc() {
        return StudentDatabase.getAllStudents()
                .stream()
                // Sorted accepts a comparator
                .sorted(Comparator.comparing(Student::getGpa).reversed()) // to reverse the sorting order
                .collect(toList());
    }

    public static List<Student> getStudentSortedByGpaDescAndGradeLevelAsc() {
        return StudentDatabase.getAllStudents()
                .stream()
                // Sorted accepts a comparator
                .sorted(Comparator.comparing(Student::getGpa).reversed()) // to reverse the sorting order
                .sorted(Comparator.comparing(Student::getGradeLevel))
                .collect(toList());
    }

    public static void main(String[] args) {

        System.out.println("Students sorted by Name:");
        getStudentSortedByName().forEach(System.out::println);

        System.out.println("Students sorted by GPA:");
        getStudentSortedByGpa().forEach(System.out::println);

        System.out.println("Students sorted by GPA DESC:");
        getStudentSortedByGpaDesc().forEach(System.out::println);

        System.out.println("Students sorted by GPA DESC and Grade Level ASC:");
        getStudentSortedByGpaDescAndGradeLevelAsc().forEach(System.out::println);
    }
}

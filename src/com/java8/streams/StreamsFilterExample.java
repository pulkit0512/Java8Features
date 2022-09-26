package com.java8.streams;

import com.java8.data.Student;
import com.java8.data.StudentDatabase;

import java.util.List;
import java.util.stream.Collectors;

public class StreamsFilterExample {

    public static List<Student> getFilteredStudents() {
        return StudentDatabase.getAllStudents().stream() // Stream<Student>
                .filter(student -> student.getGender().equals("female")) // Stream<Student> filters
                // and sends only female students
                // we can have any number of filters
                .filter(student -> student.getGpa()>=3.6)
                .collect(Collectors.toList());
    }
    public static void main(String[] args) {
        System.out.println("Filtered Students: ");
        getFilteredStudents().forEach(System.out::println);
    }
}

package com.java8.streams_terminal;

import com.java8.data.Student;
import com.java8.data.StudentDatabase;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamsMinByMaxByExample {

    public static Optional<Student> getMinGpaStudent() {
        return StudentDatabase.getAllStudents()
                .stream()
                .collect(Collectors.minBy(Comparator.comparing(Student::getGpa)));
    }

    public static Optional<Student> getMaxGpaStudent() {
        return StudentDatabase.getAllStudents()
                .stream()
                .collect(Collectors.maxBy(Comparator.comparing(Student::getGpa)));
    }

    public static Optional<Student> getMaxGpaStudentUsingStreamsMin() {
        return StudentDatabase.getAllStudents()
                .stream()
                .max(Comparator.comparing(Student::getGpa));
    }

    public static void main(String[] args) {
        //Student with minimum gpa
        Optional<Student> optionalStudent = getMinGpaStudent();
        optionalStudent.ifPresent(System.out::println);

        //Student with maximum gpa
        Optional<Student> optionalStudent1 = getMaxGpaStudent();
        optionalStudent1.ifPresent(System.out::println);

        // Same functionalities can be achieved using Stream min/max functions
        Optional<Student> optionalStudent2 = getMaxGpaStudentUsingStreamsMin();
        optionalStudent2.ifPresent(System.out::println);
    }
}

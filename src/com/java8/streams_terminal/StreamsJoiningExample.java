package com.java8.streams_terminal;

import com.java8.data.Student;
import com.java8.data.StudentDatabase;

import java.util.stream.Collectors;

public class StreamsJoiningExample {

    public static String joining() {
        return StudentDatabase.getAllStudents()
                .stream()
                .map(Student::getName)
                .collect(Collectors.joining());
    }

    public static String joiningWithDelimiter() {
        return StudentDatabase.getAllStudents()
                .stream()
                .map(Student::getName)
                .collect(Collectors.joining(", "));
    }

    public static String joiningWithDelimiterAndPrefixSuffix() {
        return StudentDatabase.getAllStudents()
                .stream()
                .map(Student::getName)
                .collect(Collectors.joining(", ", "[", "]"));
    }

    public static void main(String[] args) {
        //Concatenate all student names from student database
        System.out.println("Concatenated String of names using Joining: " + joining());

        //Concatenate all student names from student database with a delimiter
        System.out.println("Concatenated String of names using Joining with delimiter: " + joiningWithDelimiter());

        //Concatenate all student names from student database with a delimiter, prefix and suffix
        System.out.println("Concatenated String of names using Joining with delimiter, prefix and suffix: "
                + joiningWithDelimiterAndPrefixSuffix());
    }
}

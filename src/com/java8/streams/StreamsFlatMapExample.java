package com.java8.streams;

import com.java8.data.Student;
import com.java8.data.StudentDatabase;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamsFlatMapExample {

    private static List<List<String>> getActivitiesList() {
        return StudentDatabase.getAllStudents().stream() // Stream<Student>
                .map(Student::getActivities) // Stream<List<String>>
                .collect(Collectors.toList()); // List<List<String>>
    }

    private static Set<String> getUniqueActivities() {
        return StudentDatabase.getAllStudents().stream() // Stream<Student>
                .map(Student::getActivities) // Stream<List<String>>
                // flatMap used in case each element in Stream has multiple elements
                .flatMap(List::stream) // Stream<String> // flatMap flattens the nested stream
                .collect(Collectors.toSet()); // Set<String>
    }
    public static void main(String[] args) {
        System.out.println("Student Activities as different List: " + getActivitiesList());

        System.out.println("Student Unique Activities: " + getUniqueActivities());
    }
}

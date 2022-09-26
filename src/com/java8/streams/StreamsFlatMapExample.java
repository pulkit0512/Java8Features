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

    private static List<String> getDistinctSortedActivitiesList() {
        return StudentDatabase.getAllStudents().stream() // Stream<Student>
                .map(Student::getActivities) // Stream<List<String>>
                // flatMap used in case each element in Stream has multiple elements
                .flatMap(List::stream) // Stream<String> // flatMap flattens the nested stream
                .distinct() // Stream<String> with distinct function performed
                .sorted() // Sorted the stream in natural order
                .collect(Collectors.toList()); // List<String>
    }

    private static long getDistinctActivitiesCount() {
        return StudentDatabase.getAllStudents().stream() // Stream<Student>
                .map(Student::getActivities) // Stream<List<String>>
                // flatMap used in case each element in Stream has multiple elements
                .flatMap(List::stream) // Stream<String> // flatMap flattens the nested stream
                .distinct() // gives distinct activities only
                .count();// returns the count
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

        System.out.println("Student Distinct Activities in List: " + getDistinctSortedActivitiesList());

        // In case we just need the count of activities and not the activities as whole.
        // So in those cases storing the data in a collection is waste of space.
        // So instead of storing data in collection and then calling its size method we can directly count the data.
        System.out.println("Student Distinct Activities count: " + getDistinctActivitiesCount());
    }
}

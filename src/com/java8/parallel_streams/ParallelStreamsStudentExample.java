package com.java8.parallel_streams;

import com.java8.data.Student;
import com.java8.data.StudentDatabase;

import java.util.List;
import java.util.stream.Collectors;

public class ParallelStreamsStudentExample {

    private static List<String> getActivitiesListSequential() {
        long startTime = System.currentTimeMillis();
        List<String> studentActivities = StudentDatabase.getAllStudents()
                .stream() // Stream<Student>
                .map(Student::getActivities) // Stream<List<String>>
                // flatMap used in case each element in Stream has multiple elements
                .flatMap(List::stream) // Stream<String> // flatMap flattens the nested stream
                .distinct() // Stream<String> with distinct function performed
                .sorted() // Sorted the stream in natural order
                .collect(Collectors.toList()); // List<String>
        long endTime = System.currentTimeMillis();

        System.out.println("Duration of performing above operation using Sequential Stream: " + (endTime-startTime));

        return studentActivities;
    }

    private static List<String> getActivitiesListParallel() {
        long startTime = System.currentTimeMillis();
        List<String> studentActivities = StudentDatabase.getAllStudents()
                // here we can also use .stream().parallel() it will do the same
                .parallelStream() // ParallelStream<Student>
                .map(Student::getActivities) // Stream<List<String>>
                // flatMap used in case each element in Stream has multiple elements
                .flatMap(List::stream) // Stream<String> // flatMap flattens the nested stream
                .distinct() // Stream<String> with distinct function performed
                .sorted() // Sorted the stream in natural order
                .collect(Collectors.toList()); // List<String>
        long endTime = System.currentTimeMillis();

        System.out.println("Duration of performing above operation using Parallel Stream: " + (endTime-startTime));

        return studentActivities;
    }

    public static void main(String[] args) {
        // Always check performance before we assume parallel is better than sequential streams.

        System.out.println(getActivitiesListSequential());

        System.out.println(getActivitiesListParallel());
    }
}

package com.java8.streams;

import com.java8.data.Student;
import com.java8.data.StudentDatabase;

import java.util.List;

public class StreamsMapReduceExample {

    public static int getNoOfNotebooks(List<Student> students) {
        return students.stream() // Stream<Student>
                // Filters the student whose grade level is >= 3
                .filter(student -> student.getGradeLevel()>=3) // Stream<Student> with applied filter
                .map(Student::getNoOfNotebooks) // Stream<Integer> converted using map function
                // Both reduce methods works same, Integer class provides a function to sum the values in the collection.
                // reduce is a terminal operation, until this is not invoked other functions won't invoke.
                //.reduce(0, (a,b) -> a+b);
                .reduce(0, Integer::sum); // reduces to a single value using reduce function. Which returns sum of books.
    }

    public static void main(String[] args) {
        List<Student> students = StudentDatabase.getAllStudents();

        students.forEach(student -> student.setNoOfNotebooks(5 * student.getGradeLevel()));

        System.out.println("Total Number of Notebooks: " + getNoOfNotebooks(students));
    }
}

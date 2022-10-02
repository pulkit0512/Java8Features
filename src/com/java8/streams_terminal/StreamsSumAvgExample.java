package com.java8.streams_terminal;

import com.java8.data.Student;
import com.java8.data.StudentDatabase;

import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class StreamsSumAvgExample {

    public static int sumUsingCollectors(List<Student> students) {
        return students.stream()
                .collect(Collectors.summingInt(Student::getNoOfNotebooks));
    }

    public static int sumUsingStream(List<Student> students) {
        return students.stream()
                .mapToInt(Student::getNoOfNotebooks)
                .sum();
    }

    public static double avgUsingCollectors(List<Student> students) {
        return students.stream()
                .collect(Collectors.averagingInt(Student::getNoOfNotebooks));
    }

    public static double avgUsingStream(List<Student> students) {
        // Streams average returns an OptionalDouble
        OptionalDouble optionalDouble = students.stream()
                .mapToInt(Student::getNoOfNotebooks)
                .average();

        if(optionalDouble.isPresent()) {
            return optionalDouble.getAsDouble();
        }else{
            return 0;
        }
    }

    public static void main(String[] args) {
        List<Student> students = StudentDatabase.getAllStudents();
        students.forEach(student -> student.setNoOfNotebooks(5*student.getGradeLevel()));

        System.out.println("Total No. of Notebooks using Collectors.summingInt() : " + sumUsingCollectors(students));

        // Same can be achieved using stream.sum()
        System.out.println("Total No. of Notebooks using stream.sum() : " + sumUsingStream(students));

        System.out.println("Average No. of Notebooks using Collectors.summingInt() : " + avgUsingCollectors(students));

        // Average using streams
        System.out.println("Average No. of Notebooks using streams.average() : " + avgUsingStream(students));
    }
}

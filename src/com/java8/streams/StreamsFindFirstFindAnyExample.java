package com.java8.streams;

import com.java8.data.Student;
import com.java8.data.StudentDatabase;

import java.util.Optional;

public class StreamsFindFirstFindAnyExample {

    public static Optional<Student> findAnyStudent() {
        return StudentDatabase.getAllStudents().stream()
                .filter(student -> student.getGpa() >= 3.9)
                // returns any student which matches above filter
                .findAny();
    }

    public static Optional<Student> findFirstStudent() {
        return StudentDatabase.getAllStudents().stream()
                .filter(student -> student.getGpa() <= 3.0)
                // return first student which matches above filter
                .findFirst();
    }


    public static void main(String[] args) {
        Optional<Student> findAnyStudentOptional = findAnyStudent();

        if(findAnyStudentOptional.isPresent()) {
            System.out.println("Student Found: " + findAnyStudentOptional.get());
        }else{
            System.out.println("Student not found!");
        }

        Optional<Student> findFirstStudentOptional = findFirstStudent();

        if(findFirstStudentOptional.isPresent()) {
            System.out.println("Student Found: " + findFirstStudentOptional.get());
        }else{
            System.out.println("Student not found!");
        }
    }
}

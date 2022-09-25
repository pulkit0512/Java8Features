package com.java8.method_constructor_reference;

import com.java8.data.Student;
import com.java8.data.StudentDatabase;

import java.util.function.Predicate;

public class RefactorReferenceMethodExample {

    static Predicate<Student> predicate = student -> student.getGradeLevel()>=3;

    // In real world cases, it's not always possible to refactor a lambda to method reference
    static Predicate<Student> refactorMethodReference = RefactorReferenceMethodExample::testGradeLevel;

    static boolean testGradeLevel(Student s) {
        return s.getGradeLevel()>=3;
    }

    public static void main(String[] args) {
        System.out.println(predicate.test(StudentDatabase.studentSupplier.get()));

        System.out.println(refactorMethodReference.test(StudentDatabase.studentSupplier.get()));
    }
}

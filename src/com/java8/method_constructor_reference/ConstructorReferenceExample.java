package com.java8.method_constructor_reference;

import com.java8.data.Student;

import java.util.function.Function;
import java.util.function.Supplier;

public class ConstructorReferenceExample {

    // For this constructor reference to work, we need a constructor in Student class with no arguments
    static Supplier<Student> studentSupplier = Student::new;

    // For this constructor reference to word, we need a constructor in Student class which accepts one String input
    static Function<String, Student> studentFunction = Student::new;

    public static void main(String[] args) {
        System.out.println(studentSupplier.get());

        // This will set the name of student to XYZ
        System.out.println(studentFunction.apply("XYZ"));
    }
}

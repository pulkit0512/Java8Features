package com.java8.optional;

import com.java8.data.Student;
import com.java8.data.StudentDatabase;
import java.util.Optional;

public class OptionalOrElseExample {

    //orElse
    public static String optionalOrElse(Student student) {
        Optional<Student> stringOptional = Optional.ofNullable(student);

        return stringOptional.map(Student::getName).orElse("Default");
    }

    //orElseGet
    public static String optionalOrElseGet(Student student) {
        Optional<Student> stringOptional = Optional.ofNullable(student);

        return stringOptional.map(Student::getName).orElseGet(() -> "Default Name");
    }

    //orElseThrow: to throw error in case no data found
    public static String optionalOrElseThrow(Student student) {
        Optional<Student> stringOptional = Optional.ofNullable(student);

        return stringOptional.map(Student::getName).orElseThrow(() -> new RuntimeException("No Data Found!"));
    }

    public static void main(String[] args) {
        System.out.println("OrElse: " + optionalOrElse(StudentDatabase.studentSupplier.get()));
        System.out.println("OrElse: " + optionalOrElse(null));

        System.out.println("OrElseGet: " + optionalOrElseGet(StudentDatabase.studentSupplier.get()));
        System.out.println("OrElseGet: " + optionalOrElseGet(null));

        System.out.println("OrElseThrow: " + optionalOrElseThrow(StudentDatabase.studentSupplier.get()));
        System.out.println("OrElseThrow: " + optionalOrElseThrow(null));
    }
}

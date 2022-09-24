package com.java8.functional_interfaces;

import com.java8.data.Student;
import com.java8.data.StudentDatabase;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class SupplierExample {

    public static void main(String[] args) {
        // This Supplier returns a Student object
        Supplier<Student> studentSupplier = () -> new Student("Jenny",2,3.8,"female", Arrays.asList("swimming", "gymnastics","soccer"));

        // This Supplier returns list of student objects.
        Supplier<List<Student>> listSupplier = () -> StudentDatabase.getAllStudents();

        System.out.println("Student is: " + studentSupplier.get());

        System.out.println("Student List is: " + listSupplier.get());
    }
}

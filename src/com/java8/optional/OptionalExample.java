package com.java8.optional;

import com.java8.data.Student;
import com.java8.data.StudentDatabase;

import java.util.Optional;

public class OptionalExample {

    public static Student getStudent() {
        // It may return a null
        return StudentDatabase.studentSupplier.get();
    }

    public static Optional<Student> getStudentOptional() {
        return Optional.ofNullable(StudentDatabase.studentSupplier.get());
    }

    public static Optional<Student> getNullOptional() {
        return Optional.empty();
    }

    public static void main(String[] args) {
        Student student = getStudent();

        if(student!=null) {
            System.out.println(student.getName());
        }else{
            System.out.println("Student not found");
        }

        // One difference between null and Optional is null is of no type but Optional will always have a type.
        // In case of empty optional we can still execute one method to check if value present or not.
        // We can't execute any method on null.
        Optional<Student> studentOptional = getStudentOptional();

        if(studentOptional.isPresent()) {
            System.out.println(studentOptional.get().getName());
        }else{
            System.out.println("Student not found");
        }

        Optional<Student> studentEmptyOptional = getNullOptional();
        studentEmptyOptional.ifPresent(s-> System.out.println(s.getName()));
    }
}

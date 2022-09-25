package com.java8.method_constructor_reference;

import com.java8.data.Student;
import com.java8.data.StudentDatabase;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerMethodReferenceExample {

    // Normal Consumer which takes Student as input and print it.
    static Consumer<Student> c1 = student -> System.out.println(student);

    // It takes input as student and from System.out parent class call the println method
    static Consumer<Student> c2 = System.out::println;

    // Now if we want to print all activities of a student, we call printAllActivities of Student class.
    static Consumer<Student> c3 = student -> student.printAllActivities();

    // We can convert this to use method reference, ClassName::instanceMethodName
    static Consumer<Student> c4 = Student::printAllActivities;

    public static void main(String[] args) {
        List<Student> studentList = StudentDatabase.getAllStudents();

        System.out.println("Consumer Lambda Result: " );
        studentList.forEach(c1);

        System.out.println("Consumer Method Reference Result: ");
        studentList.forEach(c2);

        System.out.println("Lambda print all activities: ");
        studentList.forEach(c3);

        System.out.println("Method Reference print all activities: ");
        studentList.forEach(c4);
    }
}

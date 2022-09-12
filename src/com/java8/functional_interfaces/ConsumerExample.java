package com.java8.functional_interfaces;

import com.java8.data.Student;
import com.java8.data.StudentDatabase;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerExample {
    static Consumer<String> consumer1 = str -> System.out.println(str.toUpperCase());
    static Consumer<Student> consumer2 = student -> System.out.println(student);
    static Consumer<Student> consumer3 = student -> System.out.print(student.getName());
    static Consumer<Student> consumer4 = student -> System.out.println(student.getActivities());

    static List<Student> studentList = StudentDatabase.getAllStudents();

    public static void main(String[] args) {

        consumer1.accept("Hello Consumer Interface in Java 8!!");

        //Consumer2
        printStudent();

        //Consumer Chaining
        printNameAndActivities();

        //Consumer with Conditions, add as many consumers we want in consumer chaining
        printNameAndActivitiesUsingCondition();
    }

    public static void printStudent() {
        System.out.println("===printStudent===");
        studentList.forEach(consumer2);
    }

    public static void printNameAndActivities() {
        System.out.println("===printNameAndActivities===");
        studentList.forEach(consumer3.andThen(consumer4));
    }

    public static void printNameAndActivitiesUsingCondition() {
        System.out.println("===printNameAndActivitiesUsingCondition===");
        studentList.forEach(student -> {
            if(student.getGradeLevel()>=3) {
                consumer3.andThen(consumer4).accept(student);
            }
        });


        System.out.println("\n\n<<<2nd Condition>>>\n\n");
        studentList.forEach(student -> {
            if(student.getGradeLevel()>=3 && student.getGpa()>=3.9) {
                consumer3.andThen(consumer4).andThen(consumer2).accept(student);
            }
        });
    }
}

package com.java8.functional_interfaces;

import com.java8.data.Student;
import com.java8.data.StudentDatabase;

import java.util.List;
import java.util.function.BiConsumer;

public class BiConsumerExample {

    public static void main(String[] args) {
        BiConsumer<String, String> biConsumer = (a,b) -> System.out.println("a: " + a + " , b: " + b);

        biConsumer.accept("Hello", "World!!");

        BiConsumer<Integer, Integer> multiply = (a,b) -> System.out.println("Multiply is: " + a*b);
        BiConsumer<Integer, Integer> divide = (a,b) -> System.out.println("Division is: " + a/b);

        multiply.andThen(divide).accept(10, 5);

        printNameAndActivities();
    }

    public static void printNameAndActivities() {
        List<Student> studentList = StudentDatabase.getAllStudents();

        BiConsumer<String, List<String>> biConsumer = (a, b) -> System.out.println(a + " : " + b);

        studentList.forEach(student -> biConsumer.accept(student.getName(), student.getActivities()));
    }
}

package com.java8.functional_interfaces;

import com.java8.data.Student;
import com.java8.data.StudentDatabase;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class PredicateAndConsumerExample {

    Predicate<Student> p1 = s -> s.getGradeLevel()>=3;
    Predicate<Student> p2 = s -> s.getGpa()>=3.9;

    BiPredicate<Integer, Double>  biPredicate = (gradeLevel, gpa) -> gradeLevel>=3 && gpa>=3.9;

    BiConsumer<String, List<String>> biConsumer = (name, activities) -> System.out.println(name + " : " + activities);

    Consumer<Student> studentConsumer = student -> {
        if(p1.and(p2).test(student)) {
            biConsumer.accept(student.getName(), student.getActivities());
        }
    };

    Consumer<Student> studentConsumer1 = student -> {
        // BiPredicate tests the conditions on two inputs.
        // We can use and/or/negate operations on BiPredicate chaining
        if(biPredicate.test(student.getGradeLevel(), student.getGpa())) {
            biConsumer.accept(student.getName(), student.getActivities());
        }
    };

    // Completely modularized and easy to understand.
    // It is easy to modify the functionality, if something else needs to be changed.
    public static void main(String[] args) {
        List<Student> studentList = StudentDatabase.getAllStudents();

        new PredicateAndConsumerExample().printNameAndActivities(studentList);
    }

    public void printNameAndActivities(List<Student> studentList) {
        System.out.println("Using two predicates");
        studentList.forEach(studentConsumer);

        System.out.println("Using a BiPredicate");
        studentList.forEach(studentConsumer1);
    }
}

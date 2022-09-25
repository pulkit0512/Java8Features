package com.java8.functional_interfaces;

import com.java8.data.Student;
import com.java8.data.StudentDatabase;

import java.util.List;
import java.util.function.Predicate;

public class PredicateStudentExample {

    public static Predicate<Student> gradeLevelPredicate = s -> s.getGradeLevel()>=3;
    public static Predicate<Student> gpaPredicate = s -> s.getGpa()>=3.9;
    static List<Student> studentList = StudentDatabase.getAllStudents();

    public static void main(String[] args) {
        // Since all the conditions are predefined, we can use them anywhere we want.
        // We can pass them as variables.
        // And if we have a common utility class, that handles all the conditions. Then once creating a condition
        // there will help us to reuse it anywhere we want.
        // Lambda embraces code re-usability and helps in avoiding code duplication.
        // Simple changes to prepare cases where we need only selective conditions to meet.

        // Instead of lambda, we could have a function in utility class, where all these conditions would have handled.
        // But with lambda, we can assign all the logic to a variable, and it can be passed to other functions when needed.
        filterStudentsByGradeLevel();
        filterStudentsByGpa();
        filterStudents();
    }

    public static void filterStudentsByGradeLevel() {
        System.out.println("filterStudentsByGradeLevel");
        studentList.forEach(student -> {
            if(gradeLevelPredicate.test(student)){
                System.out.println(student);
            }
        });
    }

    public static void filterStudentsByGpa() {
        System.out.println("filterStudentsByGpa");
        studentList.forEach(student -> {
            if(gpaPredicate.test(student)){
                System.out.println(student);
            }
        });
    }

    public static void filterStudents() {
        // If we haven't used lambda then we would have hard coded all conditions where needed.
        System.out.println("filterStudents by AND condition");
        studentList.forEach(student -> {
            //If we want both conditions to meet
            if(gradeLevelPredicate.and(gpaPredicate).test(student)){
                System.out.println(student);
            }
        });

        System.out.println("filterStudents by OR condition");
        studentList.forEach(student -> {
            //If we want any of the conditions to meet
            if(gradeLevelPredicate.or(gpaPredicate).test(student)){
                System.out.println(student);
            }
        });

        System.out.println("filterStudents by NEGATE condition");
        studentList.forEach(student -> {
            //If we want none of the conditions to meet
            if(gradeLevelPredicate.or(gpaPredicate).negate().test(student)){
                System.out.println(student);
            }
        });
    }
}

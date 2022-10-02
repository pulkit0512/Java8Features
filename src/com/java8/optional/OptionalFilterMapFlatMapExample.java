package com.java8.optional;

import com.java8.data.Bike;
import com.java8.data.Student;
import com.java8.data.StudentDatabase;

import java.util.Optional;

public class OptionalFilterMapFlatMapExample {

    //Filter
    public static void optionalFilter(double gpa) {
        Optional<Student> studentOptional = Optional.ofNullable(StudentDatabase.studentSupplier.get());

        if(studentOptional.isPresent()) {
            studentOptional.filter(s->s.getGpa()>=gpa)
                    .ifPresent(s -> System.out.println(s.getName()));
        }
    }

    //Map
    public static void optionalMap(double gpa) {
        Optional<Student> studentOptional = Optional.ofNullable(StudentDatabase.studentSupplier.get());

        if(studentOptional.isPresent()) {
            Optional<String> stringOptional = studentOptional
                    .filter(s->s.getGpa()>=gpa)
                    .map(Student::getGender);

            if(stringOptional.isPresent()) {
                System.out.println(stringOptional.get());
            }else{
                System.out.println("No Student Found");
            }
        }
    }

    //FlatMap
    public static void optionalFlatMap(double gpa) {
        Optional<Student> studentOptional = Optional.ofNullable(StudentDatabase.studentSupplier.get());

        Optional<String> bikeNameOptional = studentOptional
                .filter(s -> s.getGpa()>=gpa) //Optional<Student having Optional<Bike>>
                //Here we have Optional<Student> and we need to get Optional<Bike> present inside Student
                //Only way to get this is by using flatMap as it flattens the nested objects.
                //Two level of optionals, calls flatMap to help.
                .flatMap(Student::getBike) //Optional<Bike>
                .map(Bike::getName); //Optional<String>

        if(bikeNameOptional.isPresent()) {
            System.out.println("Name: " + bikeNameOptional.get());
        }else{
            System.out.println("No Student Found");
        }

    }

    public static void main(String[] args) {
        System.out.println("==Filter==");
        optionalFilter(3.5);
        optionalFilter(4.0);

        System.out.println("==Map==");

        optionalMap(3.5);
        optionalMap(4.0);

        System.out.println("==Flat Map==");

        optionalFlatMap(3.5);
        optionalFlatMap(4.0);
    }
}

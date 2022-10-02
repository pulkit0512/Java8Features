package com.java8.default_static_methods;

import com.java8.data.Student;
import com.java8.data.StudentDatabase;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class DefaultMethodExample2 {
    static Consumer<Student> studentConsumer = System.out::println;
    static Comparator<Student> nameComparator = Comparator.comparing(Student::getName);
    static Comparator<Student> gpaComparator = Comparator.comparing(Student::getGpa);
    static Comparator<Student> gradeComparator = Comparator.comparing(Student::getGradeLevel);

    public static void sortByName(List<Student> studentList) {
        System.out.println("After sortByName: ");
        studentList.sort(nameComparator);
        studentList.forEach(studentConsumer);
    }

    public static void sortByGpa(List<Student> studentList) {
        System.out.println("After sortByGpa: ");
        studentList.sort(gpaComparator);
        studentList.forEach(studentConsumer);
    }

    public static void comparatorChaining(List<Student> studentList) {
        System.out.println("Comparator Chaining: ");
        //First sort on grade and then sort on the names in each grade
        studentList.sort(gradeComparator.thenComparing(nameComparator));
        studentList.forEach(studentConsumer);
    }

    //In case we have null values in our collection, and we need to Sort them.
    //Then Comparator class has two methods for nullsFirst and nullsLast, which tells about the positions to keep null values.
    public static void sortWithNullValues(List<Student> studentList) {
        List<Student> updatedList = new ArrayList<>(studentList);
        updatedList.add(null);
        System.out.println("After sortWithNullValues: ");
        Comparator<Student> studentComparator = Comparator.nullsFirst(nameComparator);
        updatedList.sort(studentComparator);
        updatedList.forEach(studentConsumer);
    }

    public static void main(String[] args) {
        List<Student> studentList = StudentDatabase.getAllStudents();
        System.out.println("Before Sorting: ");
        studentList.forEach(studentConsumer);

        System.out.println();
        sortByName(studentList);

        System.out.println();
        sortByGpa(studentList);

        System.out.println();
        comparatorChaining(studentList);

        System.out.println();
        sortWithNullValues(studentList);
    }
}

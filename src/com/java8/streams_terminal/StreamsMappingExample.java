package com.java8.streams_terminal;

import com.java8.data.Student;
import com.java8.data.StudentDatabase;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamsMappingExample {

    public static void main(String[] args) {
        List<String> namesList = StudentDatabase.getAllStudents()
                .stream()
                .collect(Collectors.mapping(Student::getName, Collectors.toList()));

        System.out.println("NameList: " + namesList);

        Set<String> namesSet = StudentDatabase.getAllStudents()
                .stream()
                .collect(Collectors.mapping(Student::getName, Collectors.toSet()));

        System.out.println("NameSet: " + namesSet);

        // Same can be achieved using .map().collect(toList())
        // But with above mapping we can avoid one additional intermediate operation of first transforming stream
        // to another type and then collecting to list from the new stream.
        // Here we convert the object and directly collect it in list.
        List<String> namesListUsingMap = StudentDatabase.getAllStudents()
                .stream()
                .map(Student::getName)
                .collect(Collectors.toList());

        System.out.println("NamesListUsingMap: " + namesListUsingMap);
    }
}

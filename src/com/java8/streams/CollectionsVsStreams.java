package com.java8.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class CollectionsVsStreams {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Adam");
        names.add("Harry");
        names.add("Ron");

        // We can traverse a collection more than once.
        // Explicitly declares a for loop to iterate over the list and print the values.
        // This is external iteration.
        for(String name:names){
            System.out.println(name);
        }

        for(String name:names){
            System.out.println(name);
        }

        names.remove(0);

        System.out.println(names);

        // We don't have any add or remove methods for stream.
        // So we can make modifications in collections but not in Stream
        Stream<String> nameStream = names.stream();
        // Here we don't declare any iteration method, we simply use forEach method which internally iterates over the stream.
        nameStream.forEach(System.out::println);

        // We can traverse a stream only once. More than one traversal will give error
        //nameStream.forEach(System.out::println);
    }
}

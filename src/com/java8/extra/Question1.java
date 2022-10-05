package com.java8.extra;

import java.util.*;
import java.util.function.Function;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class Question1 {

    static class Sort implements Comparator<Map.Entry<String, Long>> {

        @Override
        public int compare(Map.Entry<String, Long> o1, Map.Entry<String, Long> o2) {
            if(o1.getValue().equals(o2.getValue())){
                return 0;
            }else if(o1.getValue() > o2.getValue()){
                return 1;
            }else{
                return -1;
            }
        }
    }

    public static void main(String[] args) {
        List<String> words = Arrays.asList("Redy", "Zohne", "Redy", "Stome", "Redy", "Zohne", "Zohne", "Adam");

        // From input list of strings, get the most frequent string from the list
        Optional<Map.Entry<String, Long>> maxMapOptional = words.stream()
                .collect(groupingBy(s->s, LinkedHashMap::new, counting()))
                .entrySet()
                .stream()
                .max(new Sort());

        maxMapOptional.ifPresent(k -> System.out.println(k.getKey()));


        // From input list of strings, get the least frequent string from the list
        Optional<Map.Entry<String, Long>> minMapOptional = words.stream()
                .collect(groupingBy(s->s,counting()))
                .entrySet()
                .stream()
                .min(new Sort());

        minMapOptional.ifPresent(k -> System.out.println(k.getKey()));


        // Create frequency map of String vs it's frequency
        Map<String, Long> frequentChars = words.stream()
                .collect(groupingBy(Function.identity(),counting()));


        System.out.println(frequentChars);


    }
}

package com.java8.default_static_methods;

import java.util.List;

public interface Multiplier {

    int multiply(List<Integer> integerList);

    //default methods can be overridden by implementing classes.
    default int size(List<Integer> integerList) {
        System.out.println("Inside Multiplier Interface");
        return integerList.size();
    }

    static boolean isEmpty(List<Integer> integerList) {
        return integerList==null || integerList.isEmpty();
    }
}

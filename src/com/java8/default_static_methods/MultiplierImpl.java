package com.java8.default_static_methods;

import java.util.List;

public class MultiplierImpl implements Multiplier{
    @Override
    public int multiply(List<Integer> integerList) {
        return integerList.stream()
                .reduce(1, (a, b) -> a*b);
    }

    @Override
    public int size(List<Integer> integerList) {
        //Runtime Polymorphism decides which method to call at runtime.
        System.out.println("Inside MultiplierImpl Class");
        return integerList.size();
    }
}

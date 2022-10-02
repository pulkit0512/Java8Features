package com.java8.default_static_methods;

import java.util.Arrays;
import java.util.List;

public class MultiplierClient {

    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(2,3,4,5);
        Multiplier multiplier = new MultiplierImpl();

        System.out.println(multiplier.multiply(integerList));
        System.out.println("Size : " + multiplier.size(integerList));
        //Since it is a static method so will be called using Interface/Class name.
        System.out.println("isEmpty : " + Multiplier.isEmpty(integerList));
    }
}

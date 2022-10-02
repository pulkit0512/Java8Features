package com.java8.default_static_methods;

public interface Interface1 {

    default void methodA() {
        System.out.println("Inside method A " + Interface1.class);
    }
}

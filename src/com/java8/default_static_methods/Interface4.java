package com.java8.default_static_methods;

public interface Interface4 {

    default void methodA() {
        System.out.println("Inside method A " + Interface4.class);
    }
}

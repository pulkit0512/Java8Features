package com.java8.default_static_methods;

public interface Interface2 extends Interface1 {

    default void methodB() {
        System.out.println("Inside method B " + Interface2.class);
    }

    @Override
    default void methodA() {
        System.out.println("Inside method A " + Interface2.class);
    }
}

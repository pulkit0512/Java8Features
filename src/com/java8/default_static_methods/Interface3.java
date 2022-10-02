package com.java8.default_static_methods;

public interface Interface3 extends Interface2 {

    default void methodC() {
        System.out.println("Inside method C " + Interface3.class);
    }

    @Override
    default void methodB() {
        System.out.println("Inside method B " + Interface3.class);
    }
}

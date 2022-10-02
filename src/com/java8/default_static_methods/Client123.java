package com.java8.default_static_methods;

public class Client123 implements Interface1, Interface2, Interface3{

    @Override
    //overriding the default method in the implementation class.
    public void methodA() {
        System.out.println("Inside method A " + Client123.class);
    }

    // Order of precedence
    // 1-> Class that implements the interface
    // 2-> the sub interface that extends the interface.
    // For method A, since it is implemented by class and extended by interface 2 and also created in Interface 1
    // precedence is given to class that implements it, here Client123.
    // For method B, since it is extended by interface 3 and created in Interface 2
    // precedence is given to Interface that extends it, here Interface 3
    // For method C, it is only created in Interface 3, so it will be called from Interface 3 only.

    public static void main(String[] args) {
        Client123 client = new Client123();

        client.methodA();
        client.methodB(); // resolves to child Interface Implementation
        client.methodC();
    }
}

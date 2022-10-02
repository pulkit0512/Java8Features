package com.java8.default_static_methods;

public class Client14 implements Interface1, Interface4{
    // Since both interfaces have a same method, with same method signature, we are getting compilation issue.
    // As it confuses java to decide which method to pick.
    // Only way to resolve this issue is by implementing the common method in the Implementation class.
    // In the overridden method, either we can explicitly select the Interface which we need to use, or we can have
    // new implementation

    @Override
    public void methodA() {
        // Explicitly calling the Interface to prefer, or we can call both
        Interface1.super.methodA();
        Interface4.super.methodA();

        // New Implementation
        System.out.println("Inside Method A " + Client14.class);
    }

    public static void main(String[] args) {
        Client14 client = new Client14();

        client.methodA();
    }
}

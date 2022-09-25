## Java 8 Modern Programming
### Why Java 8?
1) Needed Java 8 for functional programming features such as Lambdas, Streams, Optionals etc.
2) Also helps in parallel programming, prior to Java 8 we need to use threads for achieving parallel programming but dealing with threads is tricky and risky.
3) With Java8 we will be able to write the functional programming code using the new functional concepts which is going to help you simplify the concurrency operations which will make use of the multiple processors whenever needed.
4) Supports creating immutable objects, which will help in solving a lot of issues in Java application because of the objects states getting changed.
5) More concise and readable code.
6) In Java 8, with functional programming we can create a function and assign that functionality to a variable and pass it around as like method parameters.
7) With Java 8, we can write the code in declarative way instead of imperative way.

### Imperative vs Declarative ways of programming
**Imperative Style of Programming**
1) Focuses on how to perform the operations. 
2) Embraces Object mutability. 
3) This style of programming lists the step by step of instructions on how
to achieve an objective. 
4) We write the code on what needs to be done in each step. 
5) Imperative style is used with classic Object-Oriented Programming.

**Declarative Style of Programming**
1) Focuses on what is the result you want. 
2) Embraces Object immutability. 
3) Analogous to SQL (Structured Query Language). Similar to SQL where we just retrieve data from without bothering about how it is done, functional programming also uses the same idea. Focuses on the result.
4) Use the functions that are already part of the library to achieve an
objective. 
5) Functional Programming uses the concept of declarative programming.

### What is Lambda Expression?
1) Lambda is equivalent to a function (method) without a name. 
2) Lambdas are also referred as Anonymous functions that has.

    • Method parameters

    • Method Body

    • Return Type 

3) Lambdas are not tied to any class like a regular method. 
4) Lambda can also be assigned to variable and passed around.
5) Lambda is mainly used to implement Functional Interfaces (SAM: Single Abstract Method).

### Functional Interfaces
1) Functional interface is an interface that has exactly one abstract method.
2) @FunctionalInterface is an annotation introduced in java 8. And all the interfaces which has one abstract method are annotated with @FunctionalInterface. 
3) This is an optional annotation, but it does validate the interfaces that are annotated with this @FunctionalInterface to make sure that the interfaces are not breaking the contract meaning it mandates the interface to have only one abstract method.
4) New functional interfaces in Java 8, with their extensions:

   • Consumer – BiConsumer
   
   • Predicate - BiPredicate
   
   • Function – BiFunction, UnaryOperator, BinaryOperator

   • Supplier
5) All these interfaces are present in java.util.function package.

#### Consumer Functional Interface
It has one method called "accept with return type as void", which takes one input and works on it. It has a default function "andThen" which is sequential call to the accept function.
If performing this operation throws an exception, the after operation will not be performed.

Params: after – the operation to perform after this operation

Returns: a composed Consumer that performs in sequence this operation followed by the after operation.

#### Bi Consumer Functional Interface
Represents an operation that accepts two input arguments and returns no result. This is the two-arity specialization of Consumer.

If we have two variables and both can be combined, then instead of creating to separate consumers for both variables better create one BiConsumer.

If there is value to have separate consumers for each, we can use that too. No performance benefits of BiConsumer over Consumer.

#### Predicate Functional Interface
It has a single abstract method called "test", which accepts an input, perform some operation and returns boolean.

It has 3 default functions: And, Or, Negate. These are used to perform logical boolean operations.

Also, it has 2 static functions: isEqual and not.

#### Bi Predicate Functional Interface
Represents a predicate (boolean-valued function) of two arguments. This is the two-arity specialization of Predicate.
Evaluates the input and returns boolean based on the input arguments matching the predicate conditions.

#### Function Functional Interface
Function in Java is nothing but a method in a class.

So using function interface, we can implement a functionality as like we call a method in Java and assign that functionality to a variable.

Really new concept, never possible before JAVA 8.

It has one abstract method called "apply", It takes an input and applies this function to that input.

It has two default methods "compose" and "andThen".

#### Bi Function Functional Interface
Represents a function that accepts two arguments and produces a result. This is the two-arity specialization of Function.

This is a functional interface whose functional method is "apply(Object, Object)".

It has one default method "andThen". It accepts a Function as a parameter, i.e. accepts output of caller function as
input and performs operation on it and returns the required output.

#### Unary Operator Functional Interface
It extends Function Functional Interface.

Since we have Function Functional Interface, then in case we have same input and output type then we can use Unary
Operator Functional Interface instead of a Function.

#### Binary Operator Functional Interface
It extends BiFunction Functional Interface.

Since we have BiFunction Functional Interface, then in case we have same inputs and output type then we can use Binary
Operator Functional Interface instead of a BiFunction.

#### Supplier Functional Interface
Opposite of Consumer Functional Interface. Takes on input and returns an output to the caller.

It has one abstract method called "get".


### Primitive Functional Interfaces
![img_1.png](primitiveFunctionalInterfaces.png)

### Current VS Preferred Functional Interface
![img.png](img.png)

## Method Reference
Introduced as part of Java 8 and its purpose is to simplify the implementation of Functional Interfaces.

We have achieved it using Lambda, it helped us move away from creating anonymous inner classes.
But Method Reference is used to simplify the lambda expression itself.

Method Reference is shortcut of writing Lambda Expressions.

#### Syntax of method reference
ClassName::instance-methodName

ClassName::static-methodName

Instance::methodName

#### Where to use method reference
Lambda expressions referring to a method directly.

Using Lambda:
Function<String,String> toUpperCaseLambda = (s)->s.toUpperCase();

Using Method Reference, it is simpler and more readable code:
Function<String,String> toUpperCaseMethodReference = String::toUpperCase;

#### Where better not to use method reference
Predicate<Student> predicateUsingLambda = (s) -> s.getGradeLevel()>=3;

Here, we have our own logic and no method is directly referred. So it's difficult to write method reference in such use cases.

## Constructor Reference
Introduced in Java 8.

Syntax:  Classname::new

We can only use Constructor Reference in context of Functional Interfaces

Example: Supplier<Student> studentSupplier = Student::new;

This returns a new Student object whenever Supplier get method is called. Exception is Student class should have default constructor only.

Invalid: Student student = Student::new; // compilation issue
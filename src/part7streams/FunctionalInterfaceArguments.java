package part7streams;

/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 7: Stream API
Topic:  Method References and Lambda Expressions
*/

// Simple Functional Interface
interface MyInterface {

    String doSomething(String s);
}

// Class implements Functional Interface
class MyClass implements MyInterface {

    public String doSomething(String s) {
        return "3.  MyClass " + s;
    }
}

public class FunctionalInterfaceArguments {
    public static void main(String[] args) {

        // Create local variable, assign lambda expression to it
        MyInterface i = (s) -> "1.  variable " + s;

        // Executing operation passing Interface parameter
        executeInterface(i);

        // Executing operation passing lambda expression directly
        executeInterface((s) -> "2.  unnamed " + s);

        // Executing operation passing method reference
        executeInterface(new MyClass()::doSomething);

        // Executing operation passing return value (interface) of
        // another method
        executeInterface(FunctionalInterfaceArguments.returnInterface());

        // executeInterface(FunctionalInterfaceArguments::testStringMethod);
    }

    // Example operation that accepts functional interface as argument
    private static void executeInterface(MyInterface i) {
        System.out.println(i.doSomething("hello"));
    }

    // Returns an interface.
    private static MyInterface returnInterface() {
        MyInterface i = (s) -> "4.  method " + s;
        return i;
    }

    private static String testStringMethod() {
        return "sda";
    }
}
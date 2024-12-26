package part4genericsandcollections;

/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 4: Generics and Collections
Topic:  Generics, create a generic class
*/

// Declaring non-generic or 'raw' type.
class SpecificallyTypedClass {

    // instance variable
    Object currentObj;

    // Constructor
    SpecificallyTypedClass(Object o) {
        this.currentObj = o;
        printType();
    }

    // instance method
    public void printType() {
        System.out.println("Instance variable type is Object, but " +
                "runtime type = " + this.currentObj.getClass().getName());
    }
}

// Declaring a generic class
class GenericallyTypedClass<T> {

    // Declaring an instance variable using type parameter
    T currentObj;

    // Constructor allows passing an object to the Generic class
    // using the type parameter T
    GenericallyTypedClass(T t) {
        this.currentObj = t;
        printType();
    }

    // instance method
    public void printType() {
        System.out.println("Instance variable type is T but compile" +
                " time type = " + this.currentObj.getClass().getName());
    }
}

public class TestGenerics {

    public static void main(String[] args) {

        // Declare and instantiate different instances of non-generic class
        SpecificallyTypedClass raw1 = new SpecificallyTypedClass("hello");
        SpecificallyTypedClass raw2 =
                new SpecificallyTypedClass(new StringBuilder("hello"));
        SpecificallyTypedClass raw3 = new SpecificallyTypedClass(10);

        // Declare and instantiate different instances of generic class

        // Declare type argument <String> on both sides of
        // assignment operator
        GenericallyTypedClass<String> generic1 =
                new GenericallyTypedClass<String>("hello");

        // Declare type argument <StringBuilder> on left side of assignment,
        // use <> diamond operator on right side
        GenericallyTypedClass<StringBuilder> generic2 =
                new GenericallyTypedClass<>(new StringBuilder("hello"));

        // Declare a LVTI (var), and specify type argument on right side of
        // assignment using  <Integer>
        var generic3 = new GenericallyTypedClass<Integer>(10);

        Object o = raw1.currentObj;

        // Code compiles, but if currentObj is not a String,
        // ClassCastException thrown
        StringBuilder s1 = (StringBuilder) o;
    }
}
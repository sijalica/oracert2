package part3Interfaces;

/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 3: Interfaces
Topic:  Limitations of default methods
*/

import java.util.Objects;

// This interface demonstrates overriding and declaring Object's 3
// public methods abstract
interface ProblemFreeInterface {

    // abstract methods overriding Object's non-private, non-final
    // methods is ok
    String toString();

    boolean equals(Object obj);

    int hashCode();

}

// This class implements interface above and implements concrete
// methods overriding the 3 public methods
class ProblemFreeClass implements ProblemFreeInterface {

    public int id;

    // Constructor
    ProblemFreeClass(int id) {
        this.id = id;
    }

    public String toString() {
        System.out.println("A Class CAN override toString()");
        return "\tProblemFreeClass{" +
                "id=" + id +
                '}';
    }

    public boolean equals(Object o) {
        System.out.println("A Class CAN override equals()");
        if (this == o) return true;
        if (!(o instanceof ProblemFreeClass)) return false;
        ProblemFreeClass that = (ProblemFreeClass) o;
        return id == that.id;
    }

    public int hashCode() {
        System.out.println("A Class CAN override hashCode()");
        return Objects.hash(id);
    }

}

// This class extends the ProblemFreeClass, demonstrating calling overloaded
// versions of equals(), hashCode() and toString().
public class InterfaceIssues extends ProblemFreeClass {

    // Constructor
    InterfaceIssues(int id) {
        super(id);
    }

    public static void main(String[] args) {
        InterfaceIssues it = new InterfaceIssues(1);
        ProblemFreeClass it2 = new InterfaceIssues(1);
        boolean isEquals = it.equals(it2);
        System.out.println("\thashCode = " + it.hashCode());
        System.out.println(it);

    }
}

interface ProblematicInterface {
//    // default methods overriding Object's public, non-final
//    // methods is not permitted.
//    default String toString() {
//        System.out.println("Default method cannot override toString()");
//        return "";
//    }
//
//    default boolean equals(Object obj) {
//        System.out.println("Default method cannot override equals()");
//        return false;
//    }
//
//    default int hashCode() {
//        System.out.println("Default method cannot override hashCode()");
//        return -1;
//    }

    default Object clone() throws CloneNotSupportedException {
        System.out.println("Default method CAN override clone()");
        return null;
    }

}
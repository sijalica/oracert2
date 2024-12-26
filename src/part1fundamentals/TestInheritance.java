package part1fundamentals;

/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 1: Java Fundamentals
Topic:  Nested Class, Extras
*/

public class TestInheritance extends OuterMost {
    public static void main(String[] args) {
        new TestInheritance().testInnerClassMembers();

//        // Static method - no instance of current class so
//        // cannot access the inner classes directly
//        new ProtectedInner();
//        new PublicInner();
    }

    private void testInnerClassMembers() {
        // non-static method - instance of current class exists so inner
        // classes (with the right access modifiers) are available...
        new ProtectedInner();
        // First Level
        new PublicInner();

        this.new ProtectedInner();
        // First Level
        this.new PublicInner();
        // Second Level
        new PublicInner().new NestedInnerSecondLevel();

        // This does not work
        // new PublicInner().NestedInnerSecondLevel();

        // Customized Second Level
        new KeepExtending();

        // Extending to the next level
        System.out.println("----Nesting even deeper ----");
        new KeepExtending().new ExtendingFurther();
    }

    // This inner class extends the inner class that was inherited
// from the OuterMost class
    class KeepExtending extends OuterMost.PublicInner {
        KeepExtending() {
            System.out.println("Extend the inner class as an " +
                    "inherited member");
        }

        class ExtendingFurther extends
                OuterMost.PublicInner.NestedInnerSecondLevel {
            ExtendingFurther() {
                System.out.println("Extending a deeper level of " +
                        "an inherited member");
            }
        }
    }
}
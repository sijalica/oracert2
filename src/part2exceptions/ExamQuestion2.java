package part2exceptions;

class FirstCloseable implements AutoCloseable {
    public void close() {  // Line 1
        throw new IllegalStateException("First could not close");
    }

    public void run() {
        System.out.println("Running First");
    }
}

class SecondCloseable implements AutoCloseable {
    public void close() throws Exception {  // Line 2
        throw new IllegalStateException("Second could not close");
    }

    public void run() {
        throw new IllegalStateException("Second could not run");
    }
}

public class ExamQuestion2 {

    public static void main(String[] args) {

        FirstCloseable first = new FirstCloseable();
        try (first; SecondCloseable second = new SecondCloseable()) {  // Line 3
            first.run();
            second.run();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

// What is the output of compiling and executing this code?
//
// A.  Compilation fails on Line 1
//
//
//
// B.  Compilation fails on Line 2
//
//
//
// C.  Compilation fails on Line 3
//
//
//
// D.  Code runs and outputs the following:
//
//
//
// Running First
//
// java.lang.IllegalStateException: Second could not run
//
//
//
// E.  Code runs and outputs the following:
//
//
//
// Running First
//
// java.lang.IllegalStateException: Second could not run
//
// at SecondCloseable.run(Test.java:20)
//
// at Test.main(Test.java:30)
//
//
//
// F.  Code runs and outputs the following:
//
//
//
// Running First
//
// java.lang.IllegalStateException: Second could not run
//
// at SecondCloseable.run(Test.java:20)
//
// at Test.main(Test.java:30)
//
// Suppressed: java.lang.IllegalStateException: Second could not close
//
// at SecondCloseable.close(Test.java:17)
//
// at Test.main(Test.java:28)
//
// Suppressed: java.lang.IllegalStateException: First could not close
//
// at FirstCloseable.close(Test.java:9)
//
// at Test.main(Test.java:28)
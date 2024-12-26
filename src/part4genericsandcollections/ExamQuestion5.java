package part4genericsandcollections; // ExamQuestion5

import java.util.ArrayList;
import java.util.List;

public class ExamQuestion5 {
    public static void main(String[] args) {
//        List<Number> list = new ArrayList<Integer>();  // Line 1
//        list.add(10L); // Line 2
//        list.add(10.0); // Line 3
//        list.add(10); // Line 4
//        System.out.println(list);
    }
}

// Correct Answer: Compile error on line 1
// You cannot assign an ArrayList<Integer> to a variable declared with the type List<Number>.
// Note that if you had typed both with <Number>, the code would have compiled and executed,
// outputting [10, 10.0, 10]. If you had typed both with <Integer>, the code would have had compiler errors
// on Line 2 and Line 3, since you cannot add a primitive long (autoboxed to Long) or a primitive double
// (autoboxed to Double) to an ArrayList<Integer>.
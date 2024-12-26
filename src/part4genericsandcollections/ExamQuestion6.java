package part4genericsandcollections;


import java.util.ArrayList;
import java.util.List;

public class ExamQuestion6 {
//    public List getListA() {
//        List<? extends Number> list = new ArrayList<>();
//        list.add(10);
//        return list;
//    }

    public List getListB() {
        List<? super Number> list = new ArrayList<>();
        list.add(10);
        return list;
    }

//    public List getListC() {
//        List<?> list = new ArrayList<>();
//        list.add(10);
//        return list;
//    }
//
//    public List getListD() {
//        List<Long> list = new ArrayList<Long>();
//        list.add(10);
//        return list;
//    }
//
//    public List getListE() {
//        List<Number> list = new ArrayList<Integer>();
//        list.add(10);
//        return list;
//    }
}

// Correct Answer: Onlu method getListB compiles
// Since the local variable is defined with a lower bound, the compiler can rest assured that any list assigned
// to this variable will not be more specific, so adding a Number (or subtype of Number) is ok.
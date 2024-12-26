package part4genericsandcollections;

import java.util.LinkedHashMap;
import java.util.Map;

public class ExamQuestion1 {
    public static void main(String[] args) {
        Map<String, Integer> map = new LinkedHashMap<>();
        map.put("Ralph", 55);

        map.merge("Ralph", 1, ExamQuestion1::mergeFunction);  // Line 1
        map.merge("Ros", 56, ExamQuestion1::mergeFunction);  // Line 2
        System.out.println(map);

    }

    static Integer mergeFunction(Integer i1, Integer i2) {
        if (i2 < 55) return null;
        return i1 + i2;  // Line 3
    }
}

// Correct Answer: {Ros=56}
// Ralph exists so the mergeFunction method is executed, and null is returned from it, so Ralph (i2 is used to test
// against < 55 and i2 in the instance of Ralph entry is 1, NOT 55), so Ralph is removed from the map.
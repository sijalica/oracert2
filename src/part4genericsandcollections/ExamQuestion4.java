package part4genericsandcollections; // ExamQuestion4

import java.util.Map;
import java.util.TreeMap;

public class ExamQuestion4 {
    public static void main(String[] args) {
        Map<String, Integer> treemap = new TreeMap<>();

        // Ralph a new employee
        int employeeNo = 1;
        treemap.compute("Ralph",
                (s1, s2) -> (s2 == null) ? employeeNo : s2 + 1);  // Line 1

        int s2 = 3;  // Line 2

        // Anne a  new employee
        treemap.compute("Anne",
                (s1, s3) -> (s1 == null) ? employeeNo + 1 : s2 + 1);  // Line 3

        System.out.println(treemap);

    }
}

// Correct Answer {Anne=4, Ralph=1}
// Ralph’s value is evaluated to 1 (s2 is the value which is null because Ralph entry did not exist), so the value
// is set to employeeNo (1). In addition, Anne is added to the map, s1 has the value ‘Anne’ so is not null,
// therefore the value for the ‘Anne’ key is set to employeeNo +1s2 + 1. In addition, a TreeMap is ordered using natural Order,
// which is alphabetical for Strings.
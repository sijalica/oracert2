package part4genericsandcollections;

import java.util.Comparator;

import java.util.*;

class Item implements Comparator<Item> {
    private int id;

    Item(int id) {
        this.id = id;
    }

    int compareTo(Item i) {
        return i.id - this.id;
    }

    public int compare(Item o1, Item o2) {
        return o1.id - o2.id;
    }

    public String toString() {
        return "" + id;
    }
}

public class ExamQuestion7 {
    public static void main(String[] args) {

        List<Item> testData = List.of(
                new Item(20),
                new Item(10),
                new Item(15)
        );
        List<Item> itemList = new ArrayList<>(testData);  // Line 1
        // Collections.sort(itemList);     // Line 2

        Set<Item> treeSet = new TreeSet(new Item(0));   // Line 3
        treeSet.addAll(testData);
        Item i1 = treeSet.iterator().next();      // Line 4

        System.out.println(i1);
    }
}

// Correct Answer: Compile error on line 2
// The class Item implements Comparator but not Comparable. Only List elements implementing Comparable can be sorted.
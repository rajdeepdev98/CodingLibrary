package Algorithms;


import java.util.HashMap;
import java.util.Map;

public class MergeExample {

    public static Integer increment(Integer oldVal, Integer delta){

        return oldVal + delta;
    }

    public static Integer decrementAndCleanUp(Integer oldVal, Integer delta){

       int newVal = oldVal + delta;
       return newVal <= 0 ? null: newVal;
    }
    public static void main(String[] args) {

        Map<String, Integer> map = new HashMap<>();

        System.out.println("=== Increment Example ===");

        // Increment
        map.merge("apple", 1, MergeExample::increment);
        map.merge("apple", 1, MergeExample::increment);
        map.merge("banana", 1, MergeExample::increment);

        System.out.println(map);
        // Output: {apple=2, banana=1}


        System.out.println("\n=== Decrement + Cleanup Example ===");

        // Decrement
        map.merge("apple", -1, MergeExample::decrementAndCleanUp);
        System.out.println(map);
        // apple becomes 1

        map.merge("apple", -1, MergeExample::decrementAndCleanUp);
        System.out.println(map);
        // apple removed because count became 0

        map.merge("banana", -1, MergeExample::decrementAndCleanUp);
        System.out.println(map);
        // banana removed
    }
}

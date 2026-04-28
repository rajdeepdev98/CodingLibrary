package Algorithms;
import java.util.*;



public class OnlineMedianFinder {

    PriorityQueue<Integer> left;   // max heap
    PriorityQueue<Integer> right;  // min heap

    public OnlineMedianFinder() {
        left = new PriorityQueue<>(Collections.reverseOrder());
        right = new PriorityQueue<>();
    }

    public void addNum(int num) {
        left.offer(num);
        right.offer(left.poll());

        if (right.size() > left.size()) {
            left.offer(right.poll());
        }
    }

    public double findMedian() {
        if (left.size() > right.size()) {
            return left.peek();
        }
        return (left.peek() + right.peek()) / 2.0;
    }
}
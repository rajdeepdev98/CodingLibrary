import java.util.*;

class OrderedMultiSet {
    private final TreeMap<Integer, Integer> map = new TreeMap<>();
    private int size = 0;

    // total number of elements (including duplicates)
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(int x) {
        return map.containsKey(x);
    }

    public void add(int x) {
        map.merge(x, 1, Integer::sum);
        size++;
    }

    public void remove(int x) {
        Integer count = map.get(x);
        if (count == null) return; // or throw if you want strict behavior

        if (count == 1) map.remove(x);
        else map.put(x, count - 1);

        size--;
    }

    public int first() {
        return map.firstKey();   // min
    }

    public int last() {
        return map.lastKey();    // max
    }

    // optional: peek without crash safety
    public Integer peekFirst() {
        return map.isEmpty() ? null : map.firstKey();
    }

    public Integer peekLast() {
        return map.isEmpty() ? null : map.lastKey();
    }

    @Override
    public String toString() {
        return map.toString();
    }
}
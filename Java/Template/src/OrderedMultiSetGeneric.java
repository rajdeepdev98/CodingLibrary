import java.util.*;

public class OrderedMultiSetGeneric<T extends Comparable<T>> {

    private final TreeMap<T, Integer> map = new TreeMap<>();
    private int size = 0;

    // total elements (including duplicates)
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(T key) {
        return map.containsKey(key);
    }

    public int count(T key) {
        return map.getOrDefault(key, 0);
    }

    public void add(T key) {
        map.merge(key, 1, Integer::sum);
        size++;
    }

    public void remove(T key) {
        Integer count = map.get(key);
        if (count == null) return; // or throw exception

        if (count == 1) {
            map.remove(key);
        } else {
            map.put(key, count - 1);
        }
        size--;
    }

    public T first() {
        return map.firstKey();
    }

    public T last() {
        return map.lastKey();
    }

    public T pollFirst() {
        T key = first();
        remove(key);
        return key;
    }

    public T pollLast() {
        T key = last();
        remove(key);
        return key;
    }

    public NavigableSet<T> uniqueElements() {
        return new TreeSet<>(map.navigableKeySet());
    }

    @Override
    public String toString() {
        return map.toString();
    }
}
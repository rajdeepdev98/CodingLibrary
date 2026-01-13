import java.time.LocalDate;
import java.util.*;

public class Warmup {

    public static void main(String[] args) {

        //arrays
        int[] arr = {5, 1, 2, 4};
        List<Integer> list = new ArrayList<>();
        for (int x : arr) {
            list.add(x);
        }
        //sort
        Collections.sort(list);
        int[] sorted = list.stream().mapToInt(Integer::intValue).toArray();


        //hashmap, frequency, sorting

        String s = "interviewWarmup";
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char ch : s.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        //sort by frequency
        List<Map.Entry<Character, Integer>> entries = new ArrayList<>(freqMap.entrySet());

        entries.sort((a, b) -> b.getValue() - a.getValue());

        for (var entry : entries) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        //StringBuilder and conversions
        //Task -> Reverse words in a sentence
        String sentence = "This is a warmup exercise";
        String[] words = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]);
            if (i != 0) sb.append(" ");
        }

        String result = sb.toString();
        System.out.println(result);

        // Sliding window( Set + Two Pointers)
        String str = "abcabcbb";
        Set<Character> window = new HashSet<>();
        int l = 0, mx = 0;
        for (int r = 0; r < str.length(); r++) {
            while (window.contains(str.charAt(r))) {
                window.remove(str.charAt(l));
                l++;
            }
            window.add(str.charAt(r));
            mx = Math.max(mx, r - l + 1);
        }
        System.out.println("Longest substring without repeating characters: " + mx);

        // Heap + K Largest Elements
        int[] nums = {3, 2, 1, 5, 6, 4};

        int k = 3;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i : nums) {

            pq.offer(i);
            if (pq.size() > k) pq.poll();
        }

        //Date + Integer/String Conversions
        LocalDate date = LocalDate.parse("2026-01-08");
        LocalDate newDate = date.plusDays(10);

        int x = 12345;
        String xS = String.valueOf(x);
        int xsI = Integer.parseInt(xS);




    }
}

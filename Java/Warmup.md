# Java Coding Interview Warm-Up Plan (1–2 Hours)

**Goal**
Refresh Java syntax, collections, data types, and common patterns so you can immediately focus on problem-solving.

---

## 0. Mental Reset — C++ → Java Mapping (5 min)

| C++ STL | Java |
|------|------|
| unordered_map | HashMap |
| map | TreeMap |
| unordered_set | HashSet |
| set | TreeSet |
| vector | ArrayList |
| deque | ArrayDeque |
| priority_queue | PriorityQueue |
| pass by reference | pass-by-value (object refs) |

---

## 1. Core Java Collections (25–30 min)

### 1.1 Maps (Most Important)

```java
Map<Integer, Integer> map = new HashMap<>();
Map<Integer, Integer> map = new LinkedHashMap<>();
Map<Integer, Integer> map = new TreeMap<>();
```

**Common Methods**

```java
map.put(k, v);
map.get(k);
map.getOrDefault(k, 0);
map.containsKey(k);
map.remove(k);
map.size();
map.isEmpty();
```

**Iteration**

```java
for (Map.Entry<Integer, Integer> e : map.entrySet()) {
    int key = e.getKey();
    int val = e.getValue();
}
```

**Useful Patterns**

```java
map.putIfAbsent(k, 0);
map.computeIfAbsent(k, x -> new ArrayList<>());
map.merge(k, 1, Integer::sum);
```

**Use cases**
- Frequency counting
- Prefix sums
- Grouping
- Two Sum

### 1.2 Sets

```java
Set<Integer> set = new HashSet<>();
Set<Integer> sorted = new TreeSet<>();

set.add(x);
set.contains(x);
set.remove(x);
set.size();
set.clear();
```

**Use cases**
- Deduplication
- Sliding window
- Fast lookup

### 1.3 Lists

```java
List<Integer> list = new ArrayList<>();

list.add(x);
list.add(i, x);
list.get(i);
list.set(i, x);
list.remove(i);
list.remove(Integer.valueOf(x));
list.contains(x);
list.size();
```

**Sorting**

```java
Collections.sort(list);
list.sort(Comparator.reverseOrder());
```

### 1.4 Arrays Utilities

```java
Arrays.sort(arr);
Arrays.fill(arr, -1);
Arrays.equals(a, b);
Arrays.binarySearch(arr, target);
Arrays.copyOf(arr, n);
Arrays.copyOfRange(arr, l, r);
```

### 1.5 Stack / Queue / Deque (Avoid Stack ❌)

```java
Deque<Integer> dq = new ArrayDeque<>();
```

**Stack**

```java
dq.push(x);
dq.pop();
dq.peek();
```

**Queue**

```java
dq.offer(x);
dq.poll();
dq.peek();
```

### 1.6 PriorityQueue (Heap)

```java
PriorityQueue<Integer> minHeap = new PriorityQueue<>();
PriorityQueue<Integer> maxHeap =
    new PriorityQueue<>(Collections.reverseOrder());

pq.offer(x);
pq.poll();
pq.peek();
pq.size();
```

---

## 2. Java Idioms & Language Essentials (30–35 min)

### 2.1 Comparator Sorting

```java
Arrays.sort(arr, (a, b) -> a[0] - b[0]);
```

**Safe:**

```java
Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));
```

**Multiple keys:**

```java
Arrays.sort(arr,
    Comparator.comparingInt((int[] a) -> a[0])
              .thenComparingInt(a -> a[1]));
```

**Custom Comparator (Multiple Ways)**

```java
// 1. Lambda (most common in interviews)
Arrays.sort(arr, (a, b) -> a.length() - b.length());

// 2. Anonymous class
Arrays.sort(arr, new Comparator<String>() {
    public int compare(String a, String b) {
        return a.length() - b.length();
    }
});

// 3. Method reference
Arrays.sort(arr, String::compareTo);

// 4. Comparator.comparing with custom logic
list.sort(Comparator.comparing(s -> s.length()));
list.sort(Comparator.comparing(String::length)
                    .thenComparing(String::compareTo));
```

**Comparable Interface (For Custom Classes)**

```java
class Person implements Comparable<Person> {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Person other) {
        // Sort by age ascending
        return Integer.compare(this.age, other.age);

        // Multiple fields
        // int result = Integer.compare(this.age, other.age);
        // if (result == 0) return this.name.compareTo(other.name);
        // return result;
    }
}

// Usage
Person[] people = {new Person("Alice", 30), new Person("Bob", 25)};
Arrays.sort(people);  // Uses compareTo
```

**compareTo() Return Values**

```java
// Return value logic:
// -1 (or negative) → this < other  (this comes before)
// 0                → this == other (equal)
// +1 (or positive) → this > other  (this comes after)

@Override
public int compareTo(Person other) {
    // Manual implementation
    if (this.age < other.age) return -1;
    if (this.age > other.age) return 1;
    return 0;

    // Or use Integer.compare (preferred)
    // return Integer.compare(this.age, other.age);
}
```

**Comparator vs Comparable**

| Feature | Comparable | Comparator |
|---------|-----------|------------|
| Location | Inside class | External |
| Method | `compareTo(T o)` | `compare(T o1, T o2)` |
| Sort types | Single (natural) | Multiple |
| Modify class | Yes | No |

**Common Patterns**

```java
// Reverse order
Arrays.sort(arr, Collections.reverseOrder());
Arrays.sort(arr, Comparator.reverseOrder());

// Sort by multiple criteria
list.sort(Comparator.comparing(Person::getAge)
                    .thenComparing(Person::getName));

// Null-safe sorting
list.sort(Comparator.nullsFirst(Comparator.naturalOrder()));
list.sort(Comparator.nullsLast(String::compareTo));

// Custom object array
Arrays.sort(intervals, (a, b) -> {
    if (a[0] != b[0]) return a[0] - b[0];
    return a[1] - b[1];
});
```

**⚠️ Integer Overflow in Comparators**

```java
// ❌ WRONG - can overflow
(a, b) -> a - b

// ✅ CORRECT
(a, b) -> Integer.compare(a, b)
Comparator.comparingInt(x -> x)
```

### 2.2 StringBuilder (Very Important)

**Why**
- String is immutable
- StringBuilder is mutable and fast

```java
StringBuilder sb = new StringBuilder();
StringBuilder sb = new StringBuilder("abc");
StringBuilder sb = new StringBuilder(100);
```

**Methods**

```java
sb.append(x);
sb.insert(i, x);
sb.deleteCharAt(i);
sb.delete(i, j);
sb.setCharAt(i, c);
sb.reverse();
sb.length();
sb.capacity();
sb.toString();
```

**❌ Avoid**

```java
s += c;
```

**String vs StringBuilder vs StringBuffer**

| Feature | String | StringBuilder | StringBuffer |
|---------|--------|---------------|--------------|
| Mutable | ❌ | ✅ | ✅ |
| Thread-safe | ✅ | ❌ | ✅ |
| Speed | Slow | Fast | Medium |

**String Substring & Manipulation Methods**

```java
String s = "Hello World";

// Substring methods
s.substring(6);           // "World" (from index to end)
s.substring(0, 5);        // "Hello" (from start to end-1)
s.substring(3, 8);        // "lo Wo" (start inclusive, end exclusive)

// Character access
s.charAt(0);              // 'H'
s.toCharArray();          // ['H','e','l','l','o',' ','W','o','r','l','d']

// Search methods
s.indexOf('o');           // 4 (first occurrence)
s.lastIndexOf('o');       // 7 (last occurrence)
s.indexOf("World");       // 6 (substring index)
s.indexOf('o', 5);        // 7 (search from index 5)
s.contains("Wor");        // true

// Boolean checks
s.startsWith("Hello");    // true
s.endsWith("World");      // true
s.isEmpty();              // false
s.isBlank();              // false (Java 11+, checks if all whitespace)

// Case conversion
s.toLowerCase();          // "hello world"
s.toUpperCase();          // "HELLO WORLD"

// Trim & Strip (Java 11+)
s.trim();                 // Removes leading/trailing spaces
s.strip();                // Unicode-aware trim (Java 11+)
s.stripLeading();         // Remove leading whitespace
s.stripTrailing();        // Remove trailing whitespace

// Replace methods
s.replace('o', '0');      // "Hell0 W0rld" (all occurrences)
s.replace("World", "Java"); // "Hello Java"
s.replaceFirst("l", "L"); // "HeLlo World" (first match)
s.replaceAll("o", "0");   // "Hell0 W0rld" (regex)

// Split & Join
String[] parts = s.split(" ");        // ["Hello", "World"]
String[] parts = s.split("\\s+");     // Split by whitespace (regex)
String joined = String.join("-", parts); // "Hello-World"

// Comparison
s.equals("Hello World");              // true (content)
s.equalsIgnoreCase("HELLO WORLD");    // true
s.compareTo("Hello Java");            // Positive (lexicographic)
s.compareToIgnoreCase("HELLO WORLD"); // 0

// Length
s.length();               // 11

// Format & Repeat
String.format("Name: %s, Age: %d", "Alice", 30); // "Name: Alice, Age: 30"
"ab".repeat(3);           // "ababab" (Java 11+)

// Other useful methods
s.concat(" !!!");         // "Hello World !!!" (better to use +)
" ".repeat(5);            // "     " (5 spaces)
```

**Common String Patterns**

```java
// Check if palindrome
boolean isPalindrome(String s) {
    int l = 0, r = s.length() - 1;
    while (l < r) {
        if (s.charAt(l++) != s.charAt(r--)) {
            return false;
        }
    }
    return true;
}

// Reverse string
String reverse(String s) {
    return new StringBuilder(s).reverse().toString();
}

// Count occurrences of character
int countChar(String s, char c) {
    int count = 0;
    for (char ch : s.toCharArray()) {
        if (ch == c) count++;
    }
    return count;
    // Or: return (int) s.chars().filter(ch -> ch == c).count();
}

// Remove all spaces
String removeSpaces(String s) {
    return s.replaceAll("\\s+", "");
}

// Check if anagram
boolean isAnagram(String s1, String s2) {
    if (s1.length() != s2.length()) return false;
    char[] arr1 = s1.toCharArray();
    char[] arr2 = s2.toCharArray();
    Arrays.sort(arr1);
    Arrays.sort(arr2);
    return Arrays.equals(arr1, arr2);
}

// Get all substrings
List<String> getAllSubstrings(String s) {
    List<String> result = new ArrayList<>();
    for (int i = 0; i < s.length(); i++) {
        for (int j = i + 1; j <= s.length(); j++) {
            result.add(s.substring(i, j));
        }
    }
    return result;
}

// Find longest common prefix
String longestCommonPrefix(String[] strs) {
    if (strs.length == 0) return "";
    String prefix = strs[0];
    for (int i = 1; i < strs.length; i++) {
        while (strs[i].indexOf(prefix) != 0) {
            prefix = prefix.substring(0, prefix.length() - 1);
            if (prefix.isEmpty()) return "";
        }
    }
    return prefix;
}
```

**StringBuilder Substring**

```java
StringBuilder sb = new StringBuilder("Hello World");

// Get substring (returns String)
String sub = sb.substring(6);      // "World"
String sub = sb.substring(0, 5);   // "Hello"

// Note: StringBuilder.substring() creates a NEW String object
// It does NOT modify the StringBuilder
```

**String Immutability Gotcha**

```java
// ❌ WRONG - creates many intermediate String objects
String result = "";
for (int i = 0; i < 1000; i++) {
    result += i;  // O(n^2) time complexity
}

// ✅ CORRECT - use StringBuilder
StringBuilder sb = new StringBuilder();
for (int i = 0; i < 1000; i++) {
    sb.append(i);  // O(n) time complexity
}
String result = sb.toString();
```

**Regular Expressions (Basic)**

```java
// Check if matches pattern
"abc123".matches("[a-z]+\\d+");   // true
"123abc".matches("\\d+[a-z]+");   // true

// Split with regex
"a1b2c3".split("\\d+");           // ["a", "b", "c", ""]

// Replace with regex
"a1b2c3".replaceAll("\\d+", "X"); // "aXbXcX"

// Common regex patterns
"\\d"     // digit
"\\D"     // non-digit
"\\s"     // whitespace
"\\S"     // non-whitespace
"\\w"     // word character [a-zA-Z0-9_]
"\\W"     // non-word character
"."       // any character
"+"       // one or more
"*"       // zero or more
"?"       // zero or one
```

### 2.3 Data Types

**Primitives**

| Type | Size | Notes |
|------|------|-------|
| int | 32-bit | default |
| long | 64-bit | sums |
| double | 64-bit | decimals |
| char | 16-bit | unicode |
| boolean | — | true/false |

**Wrapper Classes**

Integer, Long, Double, Character, Boolean

**⚠️ Autoboxing pitfall**

```java
Integer x = null;
int y = x; // NPE
```

**Integer Cache Gotcha**

```java
Integer a = 100;
Integer b = 100;
a == b; // true

Integer x = 200;
Integer y = 200;
x == y; // false
```

**✔ Always use .equals()**

**Overflow Awareness**

```java
long sum = (long) a + b;
```

### 2.4 Arrays Deep Dive

```java
int[] arr = new int[5];
int[] arr = {1,2,3};

for (int i = 0; i < arr.length; i++) {}
for (int x : arr) {}
```

### 2.5 Array ↔ List Conversion (Common Pitfall)

**❌ Wrong**

```java
Arrays.asList(intArray);
```

**✅ Correct**

```java
Integer[] arr = {1,2,3};
List<Integer> list = new ArrayList<>(Arrays.asList(arr));
```

**Primitive:**

```java
int[] arr = list.stream().mapToInt(Integer::intValue).toArray();
```

### 2.6 Integer ↔ String Conversions

```java
String s = String.valueOf(x);
int x = Integer.parseInt(s);

char c = '5';
int n = c - '0';
```

### 2.7 Character Type Checking

**Check if character is digit/letter/alphanumeric**

```java
char c = 'A';

// Check if digit (0-9)
Character.isDigit(c);           // false
c >= '0' && c <= '9';           // false (manual)

// Check if letter (a-z, A-Z)
Character.isLetter(c);          // true
(c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'); // true (manual)

// Check if letter or digit
Character.isLetterOrDigit(c);  // true

// Check if lowercase/uppercase
Character.isLowerCase(c);       // false
Character.isUpperCase(c);       // true

// Check if whitespace
Character.isWhitespace(c);      // false

// Convert case
Character.toLowerCase(c);       // 'a'
Character.toUpperCase(c);       // 'A'
```

**Common Use Cases**

```java
// Validate alphanumeric string
boolean isAlphanumeric(String s) {
    for (char c : s.toCharArray()) {
        if (!Character.isLetterOrDigit(c)) {
            return false;
        }
    }
    return true;
}

// Count digits in string
int countDigits(String s) {
    int count = 0;
    for (char c : s.toCharArray()) {
        if (Character.isDigit(c)) count++;
    }
    return count;
}

// Remove non-alphanumeric characters
String cleanString(String s) {
    StringBuilder sb = new StringBuilder();
    for (char c : s.toCharArray()) {
        if (Character.isLetterOrDigit(c)) {
            sb.append(c);
        }
    }
    return sb.toString();
}
```

**ASCII Values Quick Reference**

```java
'0' - '9'  →  48 - 57
'A' - 'Z'  →  65 - 90
'a' - 'z'  →  97 - 122

// Digit to int
int digit = '5' - '0';  // 5

// Int to char
char c = (char) ('0' + 5);  // '5'

// Case conversion (manual)
char lower = (char) (upper + 32);  // 'A' + 32 = 'a'
char upper = (char) (lower - 32);  // 'a' - 32 = 'A'
```

### 2.8 Dates & Time (Modern Java)

**✔ Use java.time**

```java
LocalDate today = LocalDate.now();
LocalDate d = LocalDate.of(2026, 1, 5);

d.plusDays(5);
d.minusMonths(1);
```

**Parsing**

```java
LocalDate.parse("2026-01-05");
```

**Formatting**

```java
DateTimeFormatter fmt =
    DateTimeFormatter.ofPattern("dd-MM-yyyy");
d.format(fmt);
```

**Comparison**

```java
d1.isBefore(d2);
d1.isAfter(d2);
```

**Difference**

```java
ChronoUnit.DAYS.between(d1, d2);
```

### 2.9 Bitwise Operations

**Basic Operators**

```java
&   // AND
|   // OR
^   // XOR
~   // NOT (complement)
<<  // Left shift
>>  // Right shift (arithmetic, sign-extended)
>>> // Unsigned right shift (zero-fill)
```

**Common Bitwise Tricks**

```java
// Check if i-th bit is set (0-indexed from right)
boolean isSet = (n & (1 << i)) != 0;

// Set i-th bit
n |= (1 << i);

// Clear i-th bit
n &= ~(1 << i);

// Toggle i-th bit
n ^= (1 << i);

// Check if power of 2
boolean isPowerOf2 = n > 0 && (n & (n - 1)) == 0;

// Count set bits (Hamming weight)
int count = Integer.bitCount(n);

// Find rightmost set bit
int rightmost = n & -n;

// Clear rightmost set bit
n &= (n - 1);

// Get all 1-bits mask
int mask = (1 << n) - 1;  // n bits set

// Swap two numbers without temp
a ^= b;
b ^= a;
a ^= b;

// Check if opposite signs
boolean oppositeSigns = (x ^ y) < 0;

// Absolute value (for non-Integer.MIN_VALUE)
int abs = (n ^ (n >> 31)) - (n >> 31);

// Min of two numbers
int min = y ^ ((x ^ y) & -(x < y ? 1 : 0));

// Max of two numbers
int max = x ^ ((x ^ y) & -(x < y ? 1 : 0));
```

**Useful Methods**

```java
// Count number of set bits
Integer.bitCount(n);

// Highest one bit
Integer.highestOneBit(n);      // 0b10110000 → 0b10000000

// Lowest one bit
Integer.lowestOneBit(n);       // 0b10110000 → 0b00010000

// Number of leading zeros
Integer.numberOfLeadingZeros(n);

// Number of trailing zeros
Integer.numberOfTrailingZeros(n);

// Reverse bits
Integer.reverse(n);

// Rotate left
Integer.rotateLeft(n, distance);

// Rotate right
Integer.rotateRight(n, distance);

// Convert to binary string
Integer.toBinaryString(n);     // "101010"
```

**Common Interview Patterns**

```java
// 1. Single Number (XOR cancels duplicates)
int singleNumber(int[] nums) {
    int result = 0;
    for (int n : nums) {
        result ^= n;  // a ^ a = 0, a ^ 0 = a
    }
    return result;
}

// 2. Check if n-th bit is set
boolean isBitSet(int num, int n) {
    return (num & (1 << n)) != 0;
}

// 3. Generate all subsets (bit masking)
List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    int n = nums.length;
    int total = 1 << n;  // 2^n subsets

    for (int mask = 0; mask < total; mask++) {
        List<Integer> subset = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if ((mask & (1 << i)) != 0) {
                subset.add(nums[i]);
            }
        }
        result.add(subset);
    }
    return result;
}

// 4. Count bits in range [0, n]
int[] countBits(int n) {
    int[] result = new int[n + 1];
    for (int i = 1; i <= n; i++) {
        result[i] = result[i >> 1] + (i & 1);
    }
    return result;
}

// 5. Hamming distance
int hammingDistance(int x, int y) {
    return Integer.bitCount(x ^ y);
}

// 6. Reverse bits
int reverseBits(int n) {
    int result = 0;
    for (int i = 0; i < 32; i++) {
        result <<= 1;
        result |= (n & 1);
        n >>= 1;
    }
    return result;
}
```

**Bit Manipulation Quick Reference**

| Operation | Formula | Example |
|-----------|---------|---------|
| Set bit | `n \| (1 << i)` | Set 2nd bit: `5 \| (1 << 2) = 7` |
| Clear bit | `n & ~(1 << i)` | Clear 2nd bit: `7 & ~(1 << 2) = 3` |
| Toggle bit | `n ^ (1 << i)` | Toggle 1st bit: `5 ^ (1 << 1) = 7` |
| Check bit | `(n & (1 << i)) != 0` | Check 0th bit: `(5 & 1) != 0 = true` |
| XOR swap | `a^=b; b^=a; a^=b;` | Swap without temp |
| Power of 2 | `n & (n-1) == 0` | `8 & 7 == 0` (true) |

**⚠️ Common Pitfalls**

```java
// ❌ Wrong - int overflow in left shift
int mask = 1 << 32;  // Undefined behavior

// ✅ Correct - use long
long mask = 1L << 32;

// ❌ Wrong - priority issues
if (n & 1 == 0)  // Parsed as: n & (1 == 0)

// ✅ Correct - use parentheses
if ((n & 1) == 0)

// ❌ Wrong - sign extension with >>
int n = -8;
int result = n >> 2;  // -2 (sign extended)

// ✅ Correct - use >>> for unsigned
int result = n >>> 2;  // 1073741822
```

**Use Cases in Interviews**

- Finding single/unique elements (XOR properties)
- Subset generation (bitmask iteration)
- Space optimization (storing flags in single int)
- Divide/multiply by powers of 2 (`n << 1` = `n * 2`, `n >> 1` = `n / 2`)
- Checking/setting/clearing specific bits
- Counting set bits
- Finding missing numbers
- Bitwise DP (traveling salesman, state compression)

**Advanced Bitwise Techniques**

```java
// 1. Isolate rightmost 0-bit
int rightmostZero = ~n & (n + 1);

// 2. Isolate trailing zeros as a block
int trailingZeros = ~n & (n - 1);

// 3. Turn on rightmost 0-bit
n |= (n + 1);

// 4. Turn off rightmost contiguous block of 1s
n &= (n + 1);

// 5. Check if all bits are set in a range
boolean allSet = ((n + 1) & n) == 0;

// 6. Extract k bits starting from position p (0-indexed from right)
int extractBits(int n, int p, int k) {
    return (n >> p) & ((1 << k) - 1);
}

// 7. Update k bits starting from position p with value val
int updateBits(int n, int p, int k, int val) {
    int mask = ((1 << k) - 1) << p;
    return (n & ~mask) | ((val << p) & mask);
}

// 8. Fast modulo for power of 2 (n % 2^k)
int fastMod = n & ((1 << k) - 1);  // Same as n % (1 << k)

// 9. Check if number has alternating bits (101010... or 010101...)
boolean hasAlternatingBits(int n) {
    int xor = n ^ (n >> 1);
    return (xor & (xor + 1)) == 0;
}

// 10. Gray Code (n-th gray code number)
int grayCode(int n) {
    return n ^ (n >> 1);
}

// Inverse Gray Code
int inverseGrayCode(int gray) {
    int n = gray;
    while (gray != 0) {
        gray >>= 1;
        n ^= gray;
    }
    return n;
}

// 11. Swap all even and odd bits
int swapEvenOddBits(int n) {
    return ((n & 0xAAAAAAAA) >>> 1) | ((n & 0x55555555) << 1);
}

// 12. Find position of rightmost set bit (1-indexed)
int rightmostSetBitPosition(int n) {
    return Integer.numberOfTrailingZeros(n) + 1;
    // Or: (int) (Math.log(n & -n) / Math.log(2)) + 1;
}

// 13. Find position of leftmost set bit (MSB)
int leftmostSetBitPosition(int n) {
    return 32 - Integer.numberOfLeadingZeros(n);
}

// 14. Next higher number with same number of set bits (Gosper's Hack)
int nextWithSameBits(int n) {
    int c = n & -n;              // Rightmost 1
    int r = n + c;               // Add it
    return r | (((n ^ r) >> 2) / c);
}

// 15. Check if bits are evenly distributed
boolean isEvenlyDistributed(int n, int totalBits) {
    return Integer.bitCount(n) == totalBits / 2;
}

// 16. Find the only non-repeating element (others appear 3 times)
int singleNumberIII(int[] nums) {
    int ones = 0, twos = 0;
    for (int n : nums) {
        twos |= ones & n;
        ones ^= n;
        int threes = ones & twos;
        ones &= ~threes;
        twos &= ~threes;
    }
    return ones;
}

// 17. Count trailing zeros (Brian Kernighan variation)
int countTrailingZeros(int n) {
    return Integer.numberOfTrailingZeros(n);
    // Or manual: count = 0; while ((n & 1) == 0) { n >>= 1; count++; }
}

// 18. Check if binary representation is palindrome
boolean isBinaryPalindrome(int n) {
    int rev = Integer.reverse(n);
    // Align to actual bit length
    int leadingZeros = Integer.numberOfLeadingZeros(n);
    rev >>>= leadingZeros;
    return n == rev;
}

// 19. Find two non-repeating elements (others appear twice)
int[] singleNumberII(int[] nums) {
    int xor = 0;
    for (int n : nums) xor ^= n;

    int rightmost = xor & -xor;  // Isolate rightmost set bit
    int[] result = new int[2];

    for (int n : nums) {
        if ((n & rightmost) != 0) {
            result[0] ^= n;
        } else {
            result[1] ^= n;
        }
    }
    return result;
}

// 20. Fast multiplication by constant using shifts
// Multiply by 7: n * 7 = n * (8 - 1) = (n << 3) - n
int multiplyBy7(int n) {
    return (n << 3) - n;
}

// Multiply by 15: n * 15 = n * (16 - 1) = (n << 4) - n
int multiplyBy15(int n) {
    return (n << 4) - n;
}

// 21. Check if adding two numbers causes overflow
boolean willAddOverflow(int a, int b) {
    return ((a ^ b) >= 0) && ((a ^ (a + b)) < 0);
}

// 22. Set all bits after the rightmost set bit
int setAllAfterRightmost(int n) {
    return n | (n - 1);
}

// 23. Clear all bits after the rightmost set bit
int clearAllAfterRightmost(int n) {
    return n & -n;
}

// 24. Round up to next power of 2
int nextPowerOf2(int n) {
    n--;
    n |= n >> 1;
    n |= n >> 2;
    n |= n >> 4;
    n |= n >> 8;
    n |= n >> 16;
    return n + 1;
}

// 25. Check if number is a power of 4
boolean isPowerOf4(int n) {
    return n > 0 && (n & (n - 1)) == 0 && (n & 0x55555555) != 0;
}

// 26. Count number of bits to flip to convert A to B
int bitFlipsToConvert(int a, int b) {
    return Integer.bitCount(a ^ b);
}

// 27. Parity check (even/odd number of 1s)
boolean hasEvenParity(int n) {
    int parity = 0;
    while (n != 0) {
        parity ^= 1;
        n &= (n - 1);  // Clear rightmost bit
    }
    return parity == 0;
}

// Or using built-in
boolean hasEvenParityFast(int n) {
    return Integer.bitCount(n) % 2 == 0;
}

// 28. Find XOR from 1 to n (pattern-based optimization)
int xorFrom1ToN(int n) {
    switch (n % 4) {
        case 0: return n;
        case 1: return 1;
        case 2: return n + 1;
        case 3: return 0;
    }
    return 0;
}
```

**Bitmask DP State Compression**

```java
// Traveling Salesman Problem (TSP) using bitmask
int tsp(int mask, int pos, int[][] dist, int[][] dp) {
    int n = dist.length;
    if (mask == (1 << n) - 1) {  // All cities visited
        return dist[pos][0];
    }

    if (dp[mask][pos] != -1) {
        return dp[mask][pos];
    }

    int ans = Integer.MAX_VALUE;
    for (int city = 0; city < n; city++) {
        if ((mask & (1 << city)) == 0) {  // City not visited
            int newAns = dist[pos][city] +
                         tsp(mask | (1 << city), city, dist, dp);
            ans = Math.min(ans, newAns);
        }
    }

    return dp[mask][pos] = ans;
}

// Check if subset sum exists using bitmask
boolean subsetSum(int[] arr, int target) {
    int n = arr.length;
    boolean[] dp = new boolean[target + 1];
    dp[0] = true;

    for (int num : arr) {
        for (int i = target; i >= num; i--) {
            dp[i] |= dp[i - num];
        }
    }
    return dp[target];
}
```

**Bit Manipulation Complexity Comparison**

| Operation | Naive | Optimized (Bitwise) |
|-----------|-------|---------------------|
| Count set bits | O(n) loop | O(k) where k = set bits |
| Power of 2 check | O(log n) | O(1) |
| Subset generation | O(n * 2^n) | O(2^n) with bitmask |
| Find duplicate | O(n) space | O(1) with XOR |

---

## 3. Mock Coding Drills (30–40 min)

- Frequency map + sorting
- Sliding window (unique substring)
- Heap — K largest
- Two Sum
- DFS / BFS

```java
void dfs(int u) {
    visited[u] = true;
    for (int v : graph[u]) {
        if (!visited[v]) dfs(v);
    }
}
```

---

## 4. Java Interview Gotchas (10 min)

- `==` vs `.equals()`
- HashMap allows one null key
- Strings are immutable
- Java is pass-by-value
- Prefer ArrayDeque over Stack
- Use long for sums

---

## 5. Final Confidence Checklist ✅

- ☑ Frequency map in seconds
- ☑ Comparator sorting without thinking
- ☑ Correct List ↔ Array conversion
- ☑ StringBuilder in loops
- ☑ Two Sum < 2 minutes

---

## 6. Java Interview Defaults Cheat Sheet

- HashMap
- HashSet
- ArrayList
- ArrayDeque
- PriorityQueue
- StringBuilder

---

**Next Steps**
- Revisit solved problems
- Practice timed questions
- Focus on patterns, not syntax

---

If you want next, I can:
- 🔥 Add **Streams (interview-safe only)**
- 🔥 Add **pattern-wise problem templates**
- 🔥 Convert this into **PDF / Notion / printable cheat-sheet**

This is now a **complete Java interview warm-up playbook** 💪

package Strings.Trie;

public class TrieExample {

    public static void main(String[] args) {

        System.out.println("=== TrieCompact Example (minimal code for CP) ===\n");
        trieCompactExample();

        System.out.println("\n=== TrieArray Example (lowercase a-z only) ===\n");
        trieArrayExample();

        System.out.println("\n=== TrieMap Example (supports any characters) ===\n");
        trieMapExample();
    }

    private static void trieCompactExample() {
        TrieCompact trie = new TrieCompact();

        // Insert words
        String[] words = {"code", "coder", "coding", "code", "cat"};
        System.out.println("Inserting words:");
        for (String word : words) {
            trie.insert(word);
            System.out.println("  - " + word);
        }

        // Search
        System.out.println("\nSearching:");
        System.out.println("  'code' exists: " + trie.search("code"));     // true
        System.out.println("  'coder' exists: " + trie.search("coder"));   // true
        System.out.println("  'cod' exists: " + trie.search("cod"));       // false

        // Prefix check
        System.out.println("\nPrefix checks:");
        System.out.println("  Starts with 'cod': " + trie.startsWith("cod"));   // true
        System.out.println("  Starts with 'ca': " + trie.startsWith("ca"));     // true
        System.out.println("  Starts with 'dog': " + trie.startsWith("dog"));   // false

        // Count words with prefix
        System.out.println("\nCount words:");
        System.out.println("  Words with prefix 'cod': " + trie.countPrefix("cod")); // 3 (code, coder, coding)
        System.out.println("  Words with prefix 'ca': " + trie.countPrefix("ca"));   // 1 (cat)
    }

    private static void trieArrayExample() {
        TrieArray trie = new TrieArray();

        // Insert words
        String[] words = {"apple", "app", "apricot", "banana", "band", "can"};
        System.out.println("Inserting words: ");
        for (String word : words) {
            trie.insert(word);
            System.out.println("  - " + word);
        }

        // Search for words
        System.out.println("\nSearching:");
        System.out.println("  'apple' exists: " + trie.search("apple"));   // true
        System.out.println("  'app' exists: " + trie.search("app"));       // true
        System.out.println("  'appl' exists: " + trie.search("appl"));     // false (prefix, not word)
        System.out.println("  'orange' exists: " + trie.search("orange")); // false

        // Check prefixes
        System.out.println("\nPrefix checks:");
        System.out.println("  Words start with 'app': " + trie.startsWith("app"));     // true
        System.out.println("  Words start with 'ban': " + trie.startsWith("ban"));     // true
        System.out.println("  Words start with 'cat': " + trie.startsWith("cat"));     // false

        // Count words with prefix
        System.out.println("\nWord count with prefix:");
        System.out.println("  Words with prefix 'app': " + trie.countWordsWithPrefix("app"));  // 3 (apple, app, apricot)
        System.out.println("  Words with prefix 'ban': " + trie.countWordsWithPrefix("ban"));  // 2 (banana, band)
        System.out.println("  Words with prefix 'c': " + trie.countWordsWithPrefix("c"));      // 1 (can)

        // Delete a word
        // Note: Delete handles multiple cases:
        // - Deleting a prefix word (e.g., 'app') keeps longer words ('apple') intact
        // - Deleting a word with shared prefixes only removes nodes not used by other words
        // - Returns false if word doesn't exist
        System.out.println("\nDeleting 'app'...");
        trie.delete("app");
        System.out.println("  'app' exists after delete: " + trie.search("app"));       // false
        System.out.println("  'apple' still exists: " + trie.search("apple"));          // true
        System.out.println("  Words with prefix 'app': " + trie.countWordsWithPrefix("app")); // 2 (apple, apricot)
    }

    private static void trieMapExample() {
        TrieMap trie = new TrieMap();

        // Insert words with various characters
        String[] words = {"Hello", "World", "123", "Test-Case", "café"};
        System.out.println("Inserting words (supports any characters): ");
        for (String word : words) {
            trie.insert(word);
            System.out.println("  - " + word);
        }

        // Search for words
        System.out.println("\nSearching:");
        System.out.println("  'Hello' exists: " + trie.search("Hello"));       // true
        System.out.println("  'hello' exists: " + trie.search("hello"));       // false (case-sensitive)
        System.out.println("  '123' exists: " + trie.search("123"));           // true
        System.out.println("  'Test-Case' exists: " + trie.search("Test-Case")); // true
        System.out.println("  'café' exists: " + trie.search("café"));         // true

        // Check prefixes
        System.out.println("\nPrefix checks:");
        System.out.println("  Words start with 'Hel': " + trie.startsWith("Hel"));    // true
        System.out.println("  Words start with 'Test': " + trie.startsWith("Test"));  // true
        System.out.println("  Words start with '12': " + trie.startsWith("12"));      // true

        // Count words with prefix
        System.out.println("\nWord count with prefix:");
        System.out.println("  Words with prefix 'H': " + trie.countWordsWithPrefix("H"));      // 1 (Hello)
        System.out.println("  Words with prefix 'Test': " + trie.countWordsWithPrefix("Test")); // 1 (Test-Case)

        // Delete a word
        System.out.println("\nDeleting 'Hello'...");
        trie.delete("Hello");
        System.out.println("  'Hello' exists after delete: " + trie.search("Hello"));  // false
        System.out.println("  'World' still exists: " + trie.search("World"));         // true
    }
}

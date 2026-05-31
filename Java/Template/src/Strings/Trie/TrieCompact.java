package Strings.Trie;

// Compact Trie - Easy to copy-paste into competitive programming solutions
// All functionality in one class, no separate node class needed
public class TrieCompact {

    TrieCompact[] children = new TrieCompact[26];
    boolean isEnd = false;

    // Insert a word
    public void insert(String word) {
        TrieCompact node = this;
        for (char c : word.toCharArray()) {
            int i = c - 'a';
            if (node.children[i] == null) {
                node.children[i] = new TrieCompact();
            }
            node = node.children[i];
        }
        node.isEnd = true;
    }

    // Search for exact word
    public boolean search(String word) {
        TrieCompact node = find(word);
        return node != null && node.isEnd;
    }

    // Check if prefix exists
    public boolean startsWith(String prefix) {
        return find(prefix) != null;
    }

    // Helper to find node for word/prefix
    private TrieCompact find(String s) {
        TrieCompact node = this;
        for (char c : s.toCharArray()) {
            int i = c - 'a';
            if (node.children[i] == null) return null;
            node = node.children[i];
        }
        return node;
    }

    // Count words with given prefix
    public int countPrefix(String prefix) {
        TrieCompact node = find(prefix);
        return node == null ? 0 : node.countWords();
    }

    private int countWords() {
        int count = isEnd ? 1 : 0;
        for (TrieCompact child : children) {
            if (child != null) count += child.countWords();
        }
        return count;
    }
}

package Strings.Trie;

public class TrieArray {

    private TrieNode root;
    private static final int ALPHABET_SIZE = 26;

    private static class TrieNode {
        TrieNode[] children;
        boolean isEndOfWord;

        TrieNode() {
            children = new TrieNode[ALPHABET_SIZE];
            isEndOfWord = false;
        }
    }

    public TrieArray() {
        root = new TrieNode();
    }

    // Insert a word into the trie
    public void insert(String word) {
        TrieNode current = root;

        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }

        current.isEndOfWord = true;
    }

    // Search for a word in the trie
    public boolean search(String word) {
        TrieNode node = searchNode(word);
        return node != null && node.isEndOfWord;
    }

    // Check if any word starts with the given prefix
    public boolean startsWith(String prefix) {
        return searchNode(prefix) != null;
    }

    // Helper method to traverse to the node representing the word/prefix
    private TrieNode searchNode(String str) {
        TrieNode current = root;

        for (char ch : str.toCharArray()) {
            int index = ch - 'a';
            if (current.children[index] == null) {
                return null;
            }
            current = current.children[index];
        }

        return current;
    }

    // Delete a word from the trie
    public boolean delete(String word) {
        return delete(root, word, 0);
    }

    private boolean delete(TrieNode current, String word, int index) {
        if (index == word.length()) {
            if (!current.isEndOfWord) {
                return false; // Word doesn't exist
            }
            current.isEndOfWord = false;
            return isEmpty(current);
        }

        int charIndex = word.charAt(index) - 'a';
        TrieNode node = current.children[charIndex];

        if (node == null) {
            return false; // Word doesn't exist
        }

        boolean shouldDeleteCurrentNode = delete(node, word, index + 1);

        if (shouldDeleteCurrentNode) {
            current.children[charIndex] = null;
            return isEmpty(current) && !current.isEndOfWord;
        }

        return false;
    }

    // Helper to check if node has no children
    private boolean isEmpty(TrieNode node) {
        for (TrieNode child : node.children) {
            if (child != null) return false;
        }
        return true;
    }

    // Count words with given prefix
    public int countWordsWithPrefix(String prefix) {
        TrieNode node = searchNode(prefix);
        if (node == null) return 0;
        return countWords(node);
    }

    private int countWords(TrieNode node) {
        int count = node.isEndOfWord ? 1 : 0;

        for (TrieNode child : node.children) {
            if (child != null) {
                count += countWords(child);
            }
        }

        return count;
    }
}

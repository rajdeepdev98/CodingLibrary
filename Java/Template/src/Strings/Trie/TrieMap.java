package Strings.Trie;

import java.util.HashMap;
import java.util.Map;

public class TrieMap {

    private TrieNode root;

    private static class TrieNode {
        Map<Character, TrieNode> children;
        boolean isEndOfWord;

        TrieNode() {
            children = new HashMap<>();
            isEndOfWord = false;
        }
    }

    public TrieMap() {
        root = new TrieNode();
    }

    // Insert a word into the trie
    public void insert(String word) {
        TrieNode current = root;

        for (char ch : word.toCharArray()) {
            current.children.putIfAbsent(ch, new TrieNode());
            current = current.children.get(ch);
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
            if (!current.children.containsKey(ch)) {
                return null;
            }
            current = current.children.get(ch);
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
            return current.children.isEmpty();
        }

        char ch = word.charAt(index);
        TrieNode node = current.children.get(ch);

        if (node == null) {
            return false; // Word doesn't exist
        }

        boolean shouldDeleteCurrentNode = delete(node, word, index + 1);

        if (shouldDeleteCurrentNode) {
            current.children.remove(ch);
            return current.children.isEmpty() && !current.isEndOfWord;
        }

        return false;
    }

    // Count words with given prefix
    public int countWordsWithPrefix(String prefix) {
        TrieNode node = searchNode(prefix);
        if (node == null) return 0;
        return countWords(node);
    }

    private int countWords(TrieNode node) {
        int count = node.isEndOfWord ? 1 : 0;

        for (TrieNode child : node.children.values()) {
            count += countWords(child);
        }

        return count;
    }
}

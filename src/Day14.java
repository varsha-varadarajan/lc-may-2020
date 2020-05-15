/*
Implement a trie with insert, search, and startsWith methods.

Example:

Trie trie = new Trie();

trie.insert("apple");
trie.search("apple");   // returns true
trie.search("app");     // returns false
trie.startsWith("app"); // returns true
trie.insert("app");
trie.search("app");     // returns true
Note:

You may assume that all inputs are consist of lowercase letters a-z.
All inputs are guaranteed to be non-empty strings.
 */

import java.util.HashMap;

public class Day14 {
    public static void main(String args[]) {
        Trie trie = new Trie();

        trie.insert("apple");
        System.out.println(trie.search("apple"));   // returns true
        System.out.println(trie.search("app"));     // returns false
        System.out.println(trie.startsWith("app")); // returns true
        trie.insert("app");
        System.out.println(trie.search("app"));     // returns true
    }
}


class Trie {

    private class TrieNode {
        HashMap<Character, TrieNode> children;
        boolean isEndOfWord;

        public TrieNode() {
            children = new HashMap<Character, TrieNode>();
            isEndOfWord = false;
        }
    }

    private final TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode currNode = root;
        for (int i=0; i<word.length(); i++) {
            char curr = word.charAt(i);
            TrieNode node = currNode.children.get(curr);
            if (node == null) {
                node = new TrieNode();
                currNode.children.put(curr, node);
            }
            currNode = node;
        }
        currNode.isEndOfWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode currNode = root;

        for (int i = 0; i < word.length(); i++) {
            char curr = word.charAt(i);
            TrieNode node = currNode.children.get(curr);
            if (node == null) {
                return false;
            }
            currNode = node;
        }
        return currNode.isEndOfWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode currNode = root;
        int i = 0;
        for (i = 0; i < prefix.length(); i++) {
            char curr = prefix.charAt(i);
            TrieNode node = currNode.children.get(curr);
            if (node == null) {
                return false;
            }
            currNode = node;
        }
        return i == prefix.length();
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

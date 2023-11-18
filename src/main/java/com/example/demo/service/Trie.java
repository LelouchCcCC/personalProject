package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

public class Trie {
    private class TrieNode {
        boolean end;
        TrieNode[] tns = new TrieNode[26];
    }

    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }

    public void insert(String s) {
        TrieNode p = root;
        for(int i = 0; i < s.length(); i++) {
            int u = s.charAt(i) - 'a';
            if (p.tns[u] == null) p.tns[u] = new TrieNode();
            p = p.tns[u];
        }
        p.end = true;
    }

    public boolean search(String s) {
        TrieNode p = root;
        for(int i = 0; i < s.length(); i++) {
            int u = s.charAt(i) - 'a';
            if (p.tns[u] == null) return false;
            p = p.tns[u];
        }
        return p.end;
    }

    public List<String> startsWith(String s) {
        List<String> results = new ArrayList<>();
        TrieNode p = root;
        for(int i = 0; i < s.length(); i++) {
            int u = s.charAt(i) - 'a';
            if (p.tns[u] == null) return null;
            p = p.tns[u];
        }
        findAllWords(p, new StringBuilder(s), results);
        return results;
    }
    private void findAllWords(TrieNode node, StringBuilder word, List<String> results) {
        if (node.end) {
            // If the node represents the end of a valid word, add it to the results list
            results.add(word.toString());
        }
        // Go through all possible children
        for (int i = 0; i < 26; i++) {
            if (node.tns[i] != null) {
                // Append the current character to the word
                char ch = (char) (i + 'a');
                word.append(ch);
                // Recursively search for words from this child node
                findAllWords(node.tns[i], word, results);
                // Backtrack to explore next possible character (remove last character)
                word.deleteCharAt(word.length() - 1);
            }
        }
    }
}

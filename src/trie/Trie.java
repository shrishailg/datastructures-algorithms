package trie;

import java.util.*;


class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // inserting string in trie
    // Time : O(N) Space: O(N)  where N is the length of the word
    public void insert(String word) {
        TrieNode current = root;

        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';

            if (Objects.isNull(current.childrens[index])) {
                current.childrens[index] = new TrieNode();
            }

            current = current.childrens[index];
        }

        current.isWordEnd = true;
        current.word = word;
    }

    // searching for a string
    // Time : O(N) Space: O(1)  where N is the length of the word
    public boolean search(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (Objects.isNull(current.childrens[index])) {
                return false;
            }

            current = current.childrens[index];
        }

        return current.isWordEnd;
    }

    // searching for a prefix
    // Time : O(N) Space: O(1)  where N is the length of the prefix
    public boolean searchPrefix(String prefix) {
        TrieNode current = root;
        for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            if (Objects.isNull(current.childrens[index])) {
                return false;
            }

            current = current.childrens[index];
        }
        return true;
    }
}

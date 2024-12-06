package trie;

import java.util.List;
import java.util.Objects;

public class Replace_Words_648 {

    public static class TrieNode {
        TrieNode[] childrens;
        boolean isWordEnd;
        String word;

        public TrieNode() {
            this.childrens = new TrieNode[26];
            this.isWordEnd = false;
            this.word = "";
        }
    }

    // time complexity n= no. of words; l is the length of each word
    // time to insert is O(n*l)
    public String replaceWords(List<String> dictionary, String sentence) {
        String[] words = sentence.split(" ");

        TrieNode root = new TrieNode();
        for (var word : dictionary) {
            insertTrie(root, word);
        }

        StringBuilder result = new StringBuilder();
        for (var word : words) {
            TrieNode temp = searchTrie(root, word);
            if (temp.isWordEnd) {
                result.append(temp.word);
                result.append(" ");
            } else {
                result.append(word);
                result.append(" ");
            }
        }

        return result.toString().trim();

    }

    public TrieNode searchTrie(TrieNode root, String word) {
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (Objects.isNull(root.childrens[index])) {
                return root;
            }

            if (root.isWordEnd) {
                return root;
            }

            root = root.childrens[index];
        }

        return root;
    }

    public void insertTrie(TrieNode root, String word) {
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';

            if (Objects.isNull(root.childrens[index])) {
                root.childrens[index] = new TrieNode();
            }

            root = root.childrens[index];
        }

        root.isWordEnd = true;
        root.word = word;
    }
}


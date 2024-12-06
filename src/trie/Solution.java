package trie;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Solution {
     int[][] directions = new int[][]{{1,0}, {-1,0}, {0, -1}, {0,1}};


    public List<String> findWords(char[][] board, String[] words) {
        int m= board.length;
        int n=board[0].length;

        List<String> result = new ArrayList<>();

       Trie trie = new Trie();
        TrieNode root = trie.root;

        for(var word:words) {
            trie.insert(word);
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++) {
                char ch = board[i][j];

                String str = "" + ch;
                if(trie.searchPrefix(str)) {
                    findWord(board, i, j, m,n, root, result);
                }
            }
        }

        return result;
    }

    private void findWord(char[][] board, int i, int j, int m, int n, TrieNode root, List<String> result){
        if(i<0 || i>=m || j<0 || j>=n) {
            return;
        }

        if (board[i][j] == '.' || Objects.isNull(root.childrens[board[i][j] - 'a'])) {
            return;
        }

        root = root.childrens[board[i][j] - 'a'];

        if (root.isWordEnd) {
            result.add(root.word);
            root.isWordEnd = false; // why?: lets say you have word bat and bate: function should
            // not stop at bat so making it to false to process further nodes to cover bate also
        }

        char temp = board[i][j]; // to enable backtracking
        board[i][j] = '.'; //once visited should not visit again on the board

        for (int[] direction : directions) {
            int x = i + direction[0];
            int y = j + direction[1];

            findWord(board, x, y, m, n, root, result);

        }

        board[i][j] = temp; // marking unvisited now
    }
}

 class TrieNode1 {
    TrieNode1[] childrens;
    String word;
    boolean isWordEnd;

    public TrieNode1(){
        this.childrens = new TrieNode1[26];
        this.isWordEnd = false;
        this.word = "";
    }
}

class Trie1 {
    TrieNode root;

    public Trie1() {
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

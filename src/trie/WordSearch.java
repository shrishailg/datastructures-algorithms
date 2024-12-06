package trie;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class WordSearch {

    static Trie trie;
    static TrieNode root;
    static int[][] directions = new int[][]{{1,0}, {-1,0}, {0, -1}, {0,1}};

    public static void main(String... args) {
        trie = new Trie();
        root = trie.root;

        char[][] board = new char[][]{{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
        String[] words = new String[]{"oath","pea","eat","rain"};

        System.out.println(findWords(board, words));
    }

    public static List<String> findWords(char[][] board, String[] words){
        int m= board.length;
        int n=board[0].length;

        List<String> result = new ArrayList<>();

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

    public static void findWord(char[][] board, int i, int j, int m, int n, TrieNode root, List<String> result){
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

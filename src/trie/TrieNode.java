package trie;

public class TrieNode {
    TrieNode[] childrens;
    String word;
    boolean isWordEnd;

    public TrieNode(){
        this.childrens = new TrieNode[26];
        this.isWordEnd = false;
        this.word = "";
    }
}
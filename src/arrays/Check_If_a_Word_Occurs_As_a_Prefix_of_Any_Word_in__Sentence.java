package arrays;

/*
Given a sentence that consists of some words separated by a single space,
and a searchWord, check if searchWord is a prefix of any word in sentence.

Return the index of the word in sentence (1-indexed) where
searchWord is a prefix of this word. If searchWord is a prefix of more than one word,
return the index of the first word (minimum index). If there is no such word return -1.

A prefix of a string s is any leading contiguous substring of s.

Input: sentence = "i love eating burger", searchWord = "burg"
Output: 4
Explanation: "burg" is prefix of "burger" which is the 4th word in the sentence.

 */
public class Check_If_a_Word_Occurs_As_a_Prefix_of_Any_Word_in__Sentence {

    public static void main(String... args) {
        String sentence = "i love eating burger";
        String searchWord = "burg";

        System.out.println(isPrefixOfWord(sentence, searchWord));
    }

    public static int isPrefixOfWord(String sentence, String searchWord) {
        String[] sentences = sentence.split(" ");

        for(int i=0;i<sentences.length;i++) {
            if(sentences[i].startsWith(searchWord)) {
                return i+1;
            }
        }

        return -1;
    }
}

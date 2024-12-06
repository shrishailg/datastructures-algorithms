package trie;

public class LongestCommonSuffix {



//    public int[] lcsOptimised() {
//        String str = "abd";
//        str.trim();
//    }


    public int[] lcsBruteForce(String[] wordsContainer, String[] wordsQuery) {
        int[] result = new int[wordsQuery.length];

        for(String wordQuery : wordsQuery) {

            int MinContainerLength = 1000000;

            for (int j = 0; j<wordsContainer.length;j++) {
                int index = j;
                int MaxSuffixLengthMatched = -1;
                int containerLength = wordsContainer[j].length();

                for(char wordQueryCh: wordQuery.toCharArray()) {

                    for(char wordsContainerCh: wordsContainer[j].toCharArray()) {
                        if (wordQueryCh == wordsContainerCh) {

                        }
                    }
                }

            }
        }

        return result;
    }
}

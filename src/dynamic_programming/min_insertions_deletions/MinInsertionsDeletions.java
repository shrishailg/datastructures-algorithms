package dynamic_programming.min_insertions_deletions;

public class MinInsertionsDeletions {

    public static void main(String... args){
        String str1 = "heap";
        String str2 = "eap";

        System.out.println(getMinInsertionsDeletions(str1, str2));
    }

    public static int getMinInsertionsDeletions(String str1, String str2) {

        int common = recursion(str1, str2, str1.length(), str2.length());
        int deletions = str1.length() - common;
        int insertions = str2.length() - common;

        return deletions + insertions;
    }

    static  int recursion(String str1, String str2, int m, int n) {
        if (m<=0 || n<=0)
            return 0;
        if (str1.charAt(m-1) == str2.charAt(n-1))
            return 1+ recursion(str1, str2, m-1, n-1);

        return Math.max(recursion(str1, str2, m-1, n), recursion(str1, str2, m, n-1));
    }
}

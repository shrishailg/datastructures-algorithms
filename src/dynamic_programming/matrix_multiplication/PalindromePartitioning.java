package dynamic_programming.matrix_multiplication;

public class PalindromePartitioning {

    public static void main(String[] args) {
        String s = "aab";
        // i starts from 0 here
        System.out.println(partition(s, 0, s.length()-1));
    }

    public static int partition(String s, int i, int j) {
        if (i>=j) {
            return 0;
        }

        if (isPalindrome(s, i, j)) {
            return 0;
        }

        int minPartitions = Integer.MAX_VALUE;

        for (int k=i;k<=j-1;k++) {
            int temp = partition(s, i, k) + partition(s, k+1,j) + 1;

            minPartitions = Math.min(minPartitions, temp);
        }

        return minPartitions;
    }

    static boolean  isPalindrome(String s, int i, int j) {
        if (i>j) {
            return true;
        }

        if (s.charAt(i) == s.charAt(j)){
            return isPalindrome(s, i+1, j-1);
        }

        return false;
    }

    public static int partitionTabulation(String s) {
        int n = s.length();
        int i=0;
        int j=n-1;

        int[][] tabulation = new int[n][n];


        if (i>=j) {
            return 0;
        }

        if (isPalindrome(s, i, j)) {
            return 0;
        }

        int minPartitions = Integer.MAX_VALUE;

        for (int k=i;k<=j-1;k++) {
            int temp = partition(s, i, k) + partition(s, k+1,j) + 1;

            minPartitions = Math.min(minPartitions, temp);
        }

        return minPartitions;
    }
}

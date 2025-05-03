package leetcode;

/*
Given an array nums of integers, return how many of them contain an even number of digits.
Input: nums = [12,345,2,6,7896]
Output: 2
Explanation:
12 contains 2 digits (even number of digits).
345 contains 3 digits (odd number of digits).
2 contains 1 digit (odd number of digits).
6 contains 1 digit (odd number of digits).
7896 contains 4 digits (even number of digits).
Therefore only 12 and 7896 contain an even number of
*/

public class lc_30th_apr_25 {

    public static void main(String[] args) {
        int[] nums = {12,345,2,6,7896};

        System.out.println(findNumbers(nums));
    }


    public static int findNumbers(int[] nums) {
        int count = 0;

        for (var num : nums) {
            if (getDigits(num) % 2 == 0) {
                count++;
            }
        }

        return count;
    }

    public static int getDigits(int n) {
        int divisor = 10;
        int count = 0;

        while (n > 0) {
            n /= divisor;
            count++;
        }

        return count;
    }
}

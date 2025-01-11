package binery_search;

/*
Suppose an array of length n sorted in ascending order is rotated between 1 and n times.
For example, the array nums = [0,1,2,4,5,6,7] might become:

[4,5,6,7,0,1,2] if it was rotated 4 times.
[0,1,2,4,5,6,7] if it was rotated 7 times.
Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].

Given the sorted rotated array nums of unique elements, return the minimum element of this array.

You must write an algorithm that runs in O(log n) time.
 */

public class MinimumInRotatedSortedArray {

    public static void main(String[] args) {
        int[] arr = {3,4,5,1,2};

        System.out.println(findMin(arr));
    }

    public static int findMin(int[] nums) {
        int low =0;
        int high = nums.length-1;

        int mini = Integer.MAX_VALUE;
        while(low <= high) {
            int mid = low + ((high-low)/2);

            //left is sorted
            if(nums[mid] >= nums[low]) {
                mini = Math.min(mini, nums[low]);
                low = mid+1;
            } else {
                mini = Math.min(mini, nums[mid]);
                high = mid-1;
            }
        }

        return mini;
    }
}

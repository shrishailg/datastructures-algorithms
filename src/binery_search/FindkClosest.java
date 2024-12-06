package binery_search;

import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class FindkClosest {

    // O(NlogN)
    public static List<Integer> findClosestElementsBruteForce(int[] nums, int k, int target) {
        List<List<Integer>> distances = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        for(var n:nums){
            List<Integer> list1 = new ArrayList<>();
            list1.add(n);
            list1.add(Math.abs(target-n));
            distances.add(list1);
        }

        distances.sort((a, b) -> a.get(1).equals(b.get(1)) ? a.get(0) - b.get(0) : a.get(1) - b.get(1));

        for(int i=0; i<k;i++){
            list.add(distances.get(i).get(0));
        }

        list.sort((a,b)-> a-b);

        return list;
    }

    public static List<Integer> findClosestElements(int[] nums, int k, int target) {

        List<Integer> closestElements = new ArrayList<>();

        if (nums.length == k) {
            for (int num : nums) {
                closestElements.add(num);
            }
            return closestElements;
        }

        if (target <= nums[0]) {
            for (int i = 0; i < k; i++) {
                closestElements.add(nums[i]);
            }
            return closestElements;
        }

        if (target >= nums[nums.length - 1]) {
            for (int i = nums.length - k; i < nums.length; i++) {
                closestElements.add(nums[i]);
            }
            return closestElements;
        }

        int firstClosest = search(nums, target);
        int windowLeft = firstClosest - 1;
        int windowRight = windowLeft + 1;

        while ((windowRight - windowLeft - 1) < k) {

            if (windowLeft == -1) {
                windowRight++;
                continue;
            }

            if (windowRight == nums.length || Math.abs(nums[windowLeft] - target) <= Math.abs(nums[windowRight] - target)) {
                windowLeft--;
            } else {
                windowRight++;
            }
        }

        for (int i = windowLeft + 1; i < windowRight; i++) {
            closestElements.add(nums[i]);
        }
        return closestElements;
    }

    public static int search(int[] nums, int target){
        int low = 0, high = nums.length;

        while (low < high){
            int mid = low + ( high - low ) / 2;
            if (nums[mid] == target)
                return nums[mid];
            if (target > nums[mid])
                low = mid + 1;
            else
                high = mid -1;
        }

        return nums[low];
    }

    // Driver code
    public static void main(String[] args) {

        int[][]inputs={
                {1, 2, 3, 4, 5, 6, 7},
                {1, 2, 3, 4, 5},
                {1, 2, 4, 5, 6},
                {1, 2, 3, 4, 5, 10}
        };
        int[] k = {4, 4, 2, 3};
        int[] x = {4, 3, 10, -5};
        for(int i=0; i<k.length; i++){
            List<Integer> kList = findClosestElementsBruteForce(inputs[i], k[i], x[i]);
            System.out.print(i+1);
            System.out.println(".\tThe "+k[i]+" closest elements for the number "+x[i]+ " in the array "+ Arrays.toString(inputs[i])+ " are: ");
            System.out.print("\t[");
            for(int j = 0; j < k[i]-1; j++) {
                System.out.print(kList.get(j) + ", ");
            }
            System.out.println(kList.get(k[i]-1) + "]");
//            System.out.println(PrintHyphens.repeat("-", 100));
        }
    }
}

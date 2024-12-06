package binery_search;

public class SearchSingleElementDuplicateArray {

    public static void main(String[] args){
        int[] nums = new int[]{1,1,2,2,3};
        int value = singleNonDuplicate(nums);
        if (value == -1){
            System.out.println("cannot be found");
        } else {
            System.out.println("found " + value);
        }
    }

    //O(N)
    public static int findDuplicate(int[] nums){
        int low=0,high=nums.length-1;
        int value = 0;
        for (int i=low;i<=high;i++){
            value ^= nums[i];
        }

        return value;
    }

    //O(logn) and space is O(1)
    public static int singleNonDuplicate(int[] nums) {
        int low = 0; int high = nums.length-1;

        while (low < high) {

            int mid = low + (high-low)/2;

            if (mid % 2 == 1)  mid-- ;

            if (nums[mid] == nums[mid+1])
                low = mid + 2;

            else
                high = mid;
        }

        return nums[low];
    }
}

package binery_search;

public class FindkthNearestElement {

    public static void main(String[] args) {

        int[] inputs ={1, 2, 3, 5, 6, 8};
        System.out.println("kth close element is "+ search(inputs, 7));
    }

    public static int search(int[] nums, int target){
        int low = 0, high = nums.length;

        while (low < high){
            int mid = low + ( high - low )/2;

            if (nums[mid] == target)
                return nums[mid];

            if (target > nums[mid]) {
                low = mid + 1;
            }
            else {
                high = mid -1;
            }
        }

        return nums[low];
    }
}

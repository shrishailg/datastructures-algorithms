package binery_search;

public class SearchSortedRotatedArray {
    public static void main(String... args){
        int[] arr = new int[]{6,7,1,2,3,4,5};

        int target = 4;
        int index = search(arr, target);
        if (index == -1){
            System.out.println("target not found in the given array");
        } else {
            System.out.println("element found at the index "+ index);
        }
    }

    public static int search(int[] arr, int target){
        int low = 0, high = arr.length -1;

        while (low <= high){
            int mid = low + ( high - low )/2;

            if (arr[mid] == target)
                return mid;

            // element may present in left array
            if (arr[mid] > arr[low]){
                if (arr[low]<= target && target < arr[mid])
                    high = mid-1;
                else
                    low = mid+1;
            } else {
                if (target > arr[mid] && target <= arr[high])
                    low = mid +1;
                else
                    high = mid-1;
            }
        }

        return -1;
    }
}

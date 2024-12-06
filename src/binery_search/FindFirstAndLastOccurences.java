package binery_search;

/*
This is called upper and lower bound of the binary search
 */
public class FindFirstAndLastOccurences {

    //Array is sorted, duplicate elements are present
    public static void main(String[] args){
        int[] arr = new int[]{9,9,9,9,11,12};
        int startIndex = search(arr, 9, true);
        System.out.println("start index is "+ startIndex);
        int endIndex = search(arr, 9, false);
        System.out.println("end index is "+ endIndex);
    }

    public static int search(int[] arr, int target, boolean isFirstIndex){
        int low = 0, high = arr.length-1;
        int res = -1;
        while(low <= high) {
            int mid = low + (high - low) / 2;

            if (target > arr[mid]){
                low = mid + 1;
            }  else if (target < arr[mid]) {
                high = mid-1;
            } else {
                res = mid;
                if (isFirstIndex){
                    high = mid -1;
                } else{
                    low = mid + 1;
                }
            }
        }

        return res;
    }
}

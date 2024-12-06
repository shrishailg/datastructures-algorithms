package binery_search;

// smaller element in the sorted rotated array
public class FindPivotPoint {
    public static void main(String... args){
        int[] arr = new int[]{6,7,1,2,3,4,5};

        int min = minimumElement(arr);
        System.out.println("minimum element in the array is "+ min);
    }

    public static int minimumElement(int[] arr){
        int low = 0, high = arr.length -1;

        //minimum element always present in unsorted arrays
        while (low <= high){
            int mid = low + ( high - low )/2;
            
            // all the elements are sorted
            if (arr[low] <= arr[high])
                return arr[low];
            
            // left array is sorted
            if (arr[mid] >= arr[low])
                low = mid + 1;

            // right array is sorted
            else
                high = mid;
        }

        return arr[low];
    }
}

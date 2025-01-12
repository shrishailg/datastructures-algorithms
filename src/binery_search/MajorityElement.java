package binery_search;

public class MajorityElement {
    /* Driver function to check for above functions*/
    public static void main (String[] args) {
        int[] arr = {1, 2, 3, 4, 4, 4, 4};
        int n = arr.length;
        int x = 4;
        if (isMajorityOptimised(arr, n, x))
            System.out.println(x+" appears more than "+
                    n/2+" times in arr[]");
        else
            System.out.println(x+" does not appear more than "+
                    n/2+" times in arr[]");
    }

    static boolean isMajorityBruteForce(int arr[], int n, int x)
    {
        int i, last_index = 0;

        /* get last index according to n (even or odd) */
        last_index = (n%2==0)? n/2: n/2+1;

        /* search for first occurrence of x in arr[]*/
        for (i = 0; i < last_index; i++)
        {
            /* check if x is present and is present more
               than n/2 times */
            if (arr[i] == x && arr[i+n/2] == x)
                return true;
        }
        return false;
    }

    static boolean isMajorityOptimised(int arr[], int n, int x) {
        int firstOccurence = binerySearchFirstOccurence(arr, 0, n, x);

        if (firstOccurence == -1)
            return false;

        return arr[firstOccurence] == x && arr[firstOccurence + n / 2] == x;
    }

    //lower bound
    static int binerySearchFirstOccurence(int arr[], int low, int high, int target) {
        int res = -1;

        while(low <= high){
            int mid = low + ( high - low ) / 2;

            if (target > arr[mid]){
                low = mid+1;
            } else if(target < arr[mid]) {
                high = mid-1;
            } else{
                res = mid;
                high = mid-1;
            }
        }

        return res;
    }

}


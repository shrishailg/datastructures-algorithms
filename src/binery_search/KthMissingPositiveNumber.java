package binery_search;

/*
Given an array arr of positive integers sorted in a strictly increasing order, and an integer k.

Return the kth positive integer that is missing from this array.
 */
public class KthMissingPositiveNumber {

    public static void main(String[] args) {
        int[] arr = {2,3,4,7,11};
        int k = 5;

        System.out.println(findKthPositive(arr, k));
        System.out.println(findKthPositiveV1(arr, k));
    }

    //using binary search
    public int findKthPositiveOptimised(int[] arr, int k) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + ((high - low) / 2);

            int missing = arr[mid] - (mid + 1);

            if (missing < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        // arr[high] + (more --> k - missing --> k - (arr[high]- high + 1))
        // arr[high] + k - arr[high] + high -1
        // high + k + 1

        return (high + 1 + k);
    }

    public static int findKthPositiveV1(int[] arr, int k) {
        int n = arr.length;
        int j = 1;
        int i = 0;
        while (k > 0) {
            if (i < n && arr[i] == j) {
                i++;
            }
            else {
                k--;
            }
            j++;
        }
        return j - 1;
    }

    public static int findKthPositive(int[] arr, int k) {
        int n = arr.length;

        for(int i=0;i<n;i++) {
            if(arr[i]<=k) {
                k++;
            } else {
                break;
            }
        }

        return k;
    }
}

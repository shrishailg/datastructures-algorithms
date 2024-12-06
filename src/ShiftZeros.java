import java.util.Arrays;

public class ShiftZeros {

    public static void main(String[] args) {
        int[] arr = {1, 2, 0, 4, -1, 5, 6, 0, 0, 7, 0};

        int low = 0,  high = arr.length-1;

        while(arr[high] == 0)
            high--;

        while(arr[low] != 0)
            low++;

        while(low <= high) {
            if (arr[low] == 0 && arr[high] != 0){
                swap(arr, low, high);
            } else if(arr[low] != 0){
                low++;
            }
            else if (arr[high] == 0){
                high--;
            }
        }

        System.out.println(Arrays.toString(arr));

    }

    public static void swap(int[] arr, int low, int high){
        int temp = arr[low];
        arr[low] = arr[high];
        arr[high] = temp;
    }
}



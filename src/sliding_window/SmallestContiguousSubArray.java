package sliding_window;

import java.util.List;

public class SmallestContiguousSubArray {

    public static void main(String[] args) {

    }

    public int findSmallestSubArray(List<Integer> array, int s) {
        int start = 0;
        int n = array.size();
        int sum = 0;
        int len = array.size();

        for(int end = 0; end<n;end++) {
            sum += array.get(end);

            while (sum>=s) {
                sum -= array.get(start);
                len = Math.min(len, end-start+1);
                start++;
            }
        }

        return len;
    }
}

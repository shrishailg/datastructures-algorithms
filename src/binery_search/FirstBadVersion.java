package binery_search;

public class FirstBadVersion {


    public int[] getFirstBadVersion(int n){
        int low = 1, high = n, mid = low, count = 0;

        while (low <= high){
            mid = low + (high - low)/2;

            if (isBadVersion(mid)){
                high = mid -1;
            } else {
                low = mid + 1;
            }
            count ++;
        }

        return new int[]{low, count};
    }

    //API call which returns if version is bad or not
    public boolean isBadVersion(int n){
        return true;
    }
}

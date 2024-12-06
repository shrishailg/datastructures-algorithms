package dynamic_programming.ribbon_cut;

public class RibbonCut {

    public int countRibbons(int[] arr, int n, int totalLength){
        if (n == 0 || totalLength == 0)
            return 0;
        if (arr[n-1] > totalLength)
            return countRibbons(arr, n-1, totalLength);
        return Math.max(countRibbons(arr, n-1, totalLength), 1 + countRibbons(arr, n, totalLength - arr[n-1]));
    }
}

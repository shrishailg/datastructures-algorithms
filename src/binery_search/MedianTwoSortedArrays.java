package binery_search;

public class MedianTwoSortedArrays {

    public static void main(String[] args) {
        int[] a = {1, 4, 7, 10, 12};
        int[] b = {2, 3, 6, 15};
        System.out.println("The median of two sorted arrays is " + medianBruteForce(a, b));

        System.out.println("The median of two sorted arrays is " + medianOptimal(a, b));
    }

    //this is brute force approach
        public static double medianBruteForce(int[] a, int[] b) {
            // Size of two given arrays
            int n1 = a.length;
            int n2 = b.length;

            int n = n1 + n2; //total size
            //required indices:
            int ind2 = n / 2;
            int ind1 = ind2 - 1;
            int cnt = 0;
            int ind1el = -1, ind2el = -1;

            //apply the merge step:
            int i = 0, j = 0;
            while (i < n1 && j < n2) {
                if (a[i] < b[j]) {
                    if (cnt == ind1) ind1el = a[i];
                    if (cnt == ind2) ind2el = a[i];
                    cnt++;
                    i++;
                } else {
                    if (cnt == ind1) ind1el = b[j];
                    if (cnt == ind2) ind2el = b[j];
                    cnt++;
                    j++;
                }
            }

            //copy the left-out elements:
            while (i < n1) {
                if (cnt == ind1) ind1el = a[i];
                if (cnt == ind2) ind2el = a[i];
                cnt++;
                i++;
            }
            while (j < n2) {
                if (cnt == ind1) ind1el = b[j];
                if (cnt == ind2) ind2el = b[j];
                cnt++;
                j++;
            }

            //Find the median:
            if (n % 2 == 1) {
                return (double)ind2el;
            }

            return (double)((double)(ind1el + ind2el)) / 2.0;
        }

        // Optimal approach: O(n1+n2)
    public static double medianOptimal(int[] a, int[] b) {
        // Size of two given arrays
        int n1 = a.length;
        int n2 = b.length;

        int n = n1 + n2; //total size
        //required indices:
        int ind2 = n / 2;
        int ind1 = ind2 - 1;
        int cnt = 0;
        int ind1el = -1, ind2el = -1;

        //apply the merge step:
        int i = 0, j = 0;
        while (i < n1 && j < n2) {
            if (a[i] < b[j]) {
                if (cnt == ind1) ind1el = a[i];
                if (cnt == ind2) ind2el = a[i];
                cnt++;
                i++;
            } else {
                if (cnt == ind1) ind1el = b[j];
                if (cnt == ind2) ind2el = b[j];
                cnt++;
                j++;
            }
        }

        //copy the left-out elements:
        while (i < n1) {
            if (cnt == ind1) ind1el = a[i];
            if (cnt == ind2) ind2el = a[i];
            cnt++;
            i++;
        }
        while (j < n2) {
            if (cnt == ind1) ind1el = b[j];
            if (cnt == ind2) ind2el = b[j];
            cnt++;
            j++;
        }

        //Find the median:
        if (n % 2 == 1) {
            return (double)ind2el;
        }

        return (double)((double)(ind1el + ind2el)) / 2.0;
    }


}

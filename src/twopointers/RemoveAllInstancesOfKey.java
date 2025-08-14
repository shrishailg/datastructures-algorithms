package twopointers;

public class RemoveAllInstancesOfKey {

    public int removeAllInstances(int[] arr, int key) {
        int nextIndex = 0;

        for(int i=0;i<arr.length;i++) {
            if (arr[i] != key) {
                arr[nextIndex] = arr[i];
                nextIndex++;
            }
        }

        return nextIndex;
    }
}

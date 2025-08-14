package twopointers;

import java.util.List;

public class ArrayLenAfterRemovingDuplicate {

    public int removeDuplicate(List<Integer> arr) {

        int nextDuplicate = 1;
        for(int i=1;i<arr.size();i++) {
            if (arr.get(nextDuplicate-1) != arr.get(i)) {
                arr.set(nextDuplicate, arr.get(i));
                nextDuplicate++;
            }
        }

        return nextDuplicate;
    }
}

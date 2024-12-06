package arrays;


import java.util.HashSet;
import java.util.Set;

/*
Given an array arr of integers, check if there exist two indices i and j such that :
Input: arr = [10,2,5,3]
Output: true
Explanation: For i = 0 and j = 2, arr[i] == 10 == 2 * 5 == 2 * arr[j]

 */
public class Check_If_N_and_Its_Double_Exist_1346 {

    public static void main(String... args) {
       int[] arr = {10,2,5,3};
        System.out.println(checkIfExist(arr));
    }

    public static boolean checkIfExist(int[] arr) {
        Set<Integer> set = new HashSet<>();

         for(var num : arr) {
         	int doubleValue = num * 2;

         	if(set.contains(doubleValue)) {
         		return true;
         	}

         	if(num%2 == 0) {
         		int reduced = num / 2;

         		if (set.contains(reduced)) {
         			return true;
         		}
         	}

         	set.add(num);
         }

         return false;
    }
}

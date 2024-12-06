public class FindMissingNumber {

    public static void main(String[] args)
    {
        int[] arr = { 1, 2, 3, 5 };
        int n = 5;
        System.out.println(missingNumber(n, arr));
    }

    public static int missingNumber(int n, int[] arr)
    {
        //  Another efficient approach is to use the XOR operation.
    //  The approach is based on the idea that XOR of a number with itself is 0, and XOR of a number with 0 is the number itself.
    //  This means that if we find XOR of first N natural numbers and then take XOR of each array elements with this,
    //  then the resultant will be the missing number.

        int xor1 = 0, xor2 = 0;

        // XOR all array elements
        for (int i = 0; i < arr.length ; i++) {
            xor2 ^= arr[i];
        }

        // XOR all numbers from 1 to n
        for (int i = 1; i <= n; i++) {
            xor1 ^= i;
        }

        // Missing number is the XOR of xor1 and xor2
        return xor1 ^ xor2;
    }

    public static int missingNumberNatural(int n, int[] arr)
    {
        int sum = 0;

        // Calculate the sum of array elements
        for (int i = 0; i < n - 1; i++) {
            sum += arr[i];
        }

        // Calculate the expected sum
        int expectedSum = (n * (n + 1)) / 2;

        // Return the missing number
        return expectedSum - sum;
    }
}

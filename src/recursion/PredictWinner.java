package recursion;


public class PredictWinner {

    public static void main(String... args) {
        int[] array = new int[]{5,4,3,6,1};
        int[] array1 = new int[]{5,4,3,6,7};

        int player1Score = recursion(array, 0, array.length-1);

        int sum = 0;
        for (var val:array){
            sum += val;
        }

        if (player1Score > sum-player1Score){
            System.out.println("player 1 is winning");
        } else {
            System.out.println("player 2 is winning");
        }

    }

    public static int recursion(int[] arr, int low, int high){
        if (low > high)
            return 0;

        int choice1 = arr[low] + Math.min(recursion(arr, low + 2, high), recursion(arr, low + 1, high-1));
        int choice2 = arr[high] + Math.min(recursion(arr, low + 1, high - 1), recursion(arr, low , high-2));

        return Math.max(choice1, choice2);
    }
}

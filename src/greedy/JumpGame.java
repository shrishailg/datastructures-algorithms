package greedy;

public class JumpGame {

    public static void main(String... args){
        int[] nums = new int[]{2,3,1,1,4};
        System.out.println(jumpGame(nums));
        int[] nums1 = new int[]{3,2,1,0,4};
        System.out.println(jumpGame(nums1));
    }

    public static boolean jumpGame(int[] nums) {
        int i = 0;
        while(i < nums.length) {
            int endIndex = nums[i] + i;
            if(endIndex >= nums.length-1){
                return true;
            } else if (nums[endIndex] == 0){
                return false;
            }
            i = i + nums[i];
        }
        return false;
    }
}

package greedy;

public class JumpGameNoJumps {

    public static void main(String... args){
        int[] nums = new int[]{2,3,1,1,4};
        System.out.println(jumpGame(nums));

        int[] nums2 = new int[]{3,2,1,1,4};
        System.out.println(jumpGame(nums2));

//        int[] nums1 = new int[]{3,2,1,0,4};
//        System.out.println(jumpGame(nums1));
    }

    public static int jumpGame(int[] nums) {

        int jumps = 0, farthestJump = 0, currentJump = 0;

        for(int i = 0 ; i < nums.length ; i++) {
            farthestJump = Math.max(farthestJump, i + nums[i]);

            if (i == currentJump) {
                currentJump = farthestJump;
                jumps++;

                if(currentJump >= nums.length-1) {
                    return jumps;
                }
            }
        }
        return jumps;
    }
}

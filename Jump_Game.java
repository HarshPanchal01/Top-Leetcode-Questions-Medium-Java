public class Jump_Game {
    public static boolean canJump(int[] nums) {
        int goalpost = nums.length - 1; // lets set our goalpost to the end goal
        // iterate backwards through array
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= goalpost) { // change the value of this to increment down if previous element can reach goal
                goalpost = i;
            }
        }
        // return true if we go back to the 0 element, otherwise false
        if (goalpost == 0) {
            return true;
        }
        else {
            return false;
        }
    }
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        int[] nums2 = {3,2,1,0,4};

        System.out.println(canJump(nums));
        System.out.println(canJump(nums2));
    }
}

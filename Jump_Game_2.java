public class Jump_Game_2 {
    public static int jump(int[] nums) {
        int result = 0, left = 0, right = 0; // set out pointers
        // loop through until end of array
        while (right < nums.length - 1) {
            int farthest = 0;
            for (int i = left; i < right + 1; i++) { // loop through the range between left and right pointer
                if (farthest < i + nums[i]) { // if farthest is less than the max then update the variable
                    farthest = i + nums[i];
                }
            }
            left = right + 1; // set new left and right for next loop between those ranges
            right = farthest;
            result += 1; // increment counter for jumping
        }
        // return the result
        return result;
    }
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(jump(nums));

        int[] nums2 = {2,3,0,1,4};
        System.out.println(jump(nums2));
    }
}

public class Maximum_Subarray {
    public static int maxSubArray(int[] nums) { 
        int max = nums[0]; // initialize max first with the first element
        int cur_sum = 0; // counter for current sum
        // for each element in the array add to current sum and set max to the max between current sum and current max
        for (int num : nums) {
            if (cur_sum < 0) { // if at any point the current sum goes below 0 start counting it again from 0
                cur_sum = 0;
            }
            cur_sum += num;
            max = Math.max(max, cur_sum);
        }
        // return the max
        return max;
    }
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int[] nums2 = {1};
        int[] nums3 = {5,4,-1,7,8};

        System.out.println(maxSubArray(nums));
        System.out.println(maxSubArray(nums2));
        System.out.println(maxSubArray(nums3));
    }
}

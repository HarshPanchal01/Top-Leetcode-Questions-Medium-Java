public class Search_Rotated_Sorted_Array {
    public static int search(int[] nums, int target) { // needs to be done in O(log(n)) time complexity
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            if (nums[left] == target) {
                return left;
            }
            else if (nums[right] == target) {
                return right;
            }
            left++;
            right--;
        }

        return -1;
    }
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int target = 0, target2 = 3;

        int[] nums2 = {1};
        int target3 = 0;

        System.out.println(search(nums, target));
        System.out.println(search(nums, target2));
        System.out.println(search(nums2, target3));
    }
}

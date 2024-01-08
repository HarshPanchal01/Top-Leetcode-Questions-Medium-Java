public class Search_Rotated_Sorted_Array {
    public static int search(int[] nums, int target) {
        // Initialize left and right pointers for binary search
        int left = 0, right = nums.length - 1;
        // Perform binary search
        while (left <= right) {
            // Calculate middle index
            int mid = left + (right - left) / 2;
            // Check if the middle element is the target
            if (nums[mid] == target) {
                return mid;
            }
            // Check if the left half is sorted
            if (nums[left] <= nums[mid]) {
                // Check if the target is in the left half
                if (nums[left] <= target && target < nums[mid]) {
                    // Adjust the right pointer to search in the left half
                    right = mid - 1;
                } else {
                    // Adjust the left pointer to search in the right half
                    left = mid + 1;
                }
            } 
            else {
                // Right half is sorted
                // Check if the target is in the right half
                if (nums[mid] < target && target <= nums[right]) {
                    // Adjust the left pointer to search in the right half
                    left = mid + 1;
                } else {
                    // Adjust the right pointer to search in the left half
                    right = mid - 1;
                }
            }
        }
        // Target not found
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

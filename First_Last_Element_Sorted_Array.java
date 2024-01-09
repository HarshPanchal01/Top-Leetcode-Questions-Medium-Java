import java.util.ArrayList;
import java.util.Arrays;

public class First_Last_Element_Sorted_Array {
    public static int[] searchRange(int[] nums, int target) {
        int[] notFound = {-1, -1}; // create the array if target is not found
        // if there is only one element and it is the target
        if (nums.length == 1 && nums[0] == target) {
            int[] found = {0, 0};
            return found;
        }
        // if there is only one element and it is not the target
        if (nums.length == 1 && nums[0] != target || nums.length == 0) {
            return notFound;
        }
        // pointers for left and right
        int left = 0, right = nums.length - 1;
        // set variables for the first and last occurences intially to -1 so if target is not found just return them
        int firstOccurrence = -1, lastOccurrence = -1;

        // Binary search to find the first occurrence
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // update firstOccurrence everytime it is found and move the right pointer down
            if (nums[mid] == target) {
                firstOccurrence = mid;
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        // If target not found
        if (firstOccurrence == -1) {
            return notFound;
        }

        // Reset left and right for the second binary search
        left = 0;
        right = nums.length - 1;

        // Binary search to find the last occurrence
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // update lastOccurrence everytime it is found and move the left pointer up
            if (nums[mid] == target) {
                lastOccurrence = mid;
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        // return the first and last occurence
        return new int[]{firstOccurrence, lastOccurrence};

    }
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 8, target2 = 6, target3 = 0, target4 = 1;
        int[] nums2 = {};
        int[] nums3 = {1};

        System.out.println(Arrays.toString(searchRange(nums, target)));
        System.out.println(Arrays.toString(searchRange(nums, target2)));
        System.out.println(Arrays.toString(searchRange(nums2, target3)));
        System.out.println(Arrays.toString(searchRange(nums3, target4)));
    }
}

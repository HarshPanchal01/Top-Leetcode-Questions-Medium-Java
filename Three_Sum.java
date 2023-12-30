import java.util.*;

public class Three_Sum {
    public static List<List<Integer>> threeSum(int[] nums) {
        // Brute force algorithm with O(n^3) needs improvement
        //for (int i = 0; i < nums.length; i++) {
        //    if (i == nums.length) {
        //        break;
        //    }
        //    for (int j = i + 1; j < nums.length; j++) {
        //        if (j == nums.length) {
        //            break;
        //        }
        //        for (int k = j + 1; k < nums.length; k++) {
        //            if (nums[i] + nums[j] + nums[k] == 0) {
        //                List<Integer> triplet = new ArrayList<>();
        //                triplet.add(nums[i]);
        //                triplet.add(nums[j]);
        //                triplet.add(nums[k]);
        //                Collections.sort(triplet);
        //                if (triplets.contains(triplet) == false) {
        //                    triplets.add(triplet);
        //                }
        //            } 
        //        }
        //    }
        //}

        // Optimized O(n^2) best solution possible
        Arrays.sort(nums); // sort the array first
        List<List<Integer>> triplets = new ArrayList<>(); // create the list of lists to store the lists

        for (int i = 0; i < nums.length - 2; i++) { // nums.length - 2 because we are looking after current element for atleast 2 elements because we need 3 elements
            if (i == 0 || (i > 0 && nums[i] != nums[i-1])) { // if element is not the same as last avoiding any duplicates since we sorted
                int leftendpoint = i+1, rightendpoint = nums.length-1; // get a left and right endpoint
                int sum = 0-nums[i]; // make the sum be 0 - the current element as we want to do two sum to find two elements that will equal that so they will cancel out and give 0

                while (leftendpoint < rightendpoint) { // while the endpoints arent the same
                    if (nums[leftendpoint] + nums[rightendpoint] == sum) { // if the two elements do equal sum which is the current element then add as list
                        triplets.add(Arrays.asList(nums[i], nums[leftendpoint], nums[rightendpoint]));
                        while (leftendpoint < rightendpoint && nums[leftendpoint] == nums[leftendpoint+1]) { // avoiding duplicates
                            leftendpoint++;
                        }
                        while (leftendpoint < rightendpoint && nums[rightendpoint] == nums[rightendpoint-1]) { // avoiding duplicates
                            rightendpoint--;
                        }
                        leftendpoint++;
                        rightendpoint--;
                    }
                    else if (nums[leftendpoint] + nums[rightendpoint] > sum) { // because they are sorted if they add to greater than the sum decrease right side
                        rightendpoint--;
                    }
                    else { // else if they are lower then increase left side
                        leftendpoint++;
                    }
                }
            }
        }

        return triplets;
    }
    public static void main(String args[]) {
        int[] nums = {-1,0,1,2,-1,-4};
        int[] nums2 = {0,1,1};
        int[] nums3 = {0,0,0};

        System.out.println(threeSum(nums));
        System.out.println(threeSum(nums2));
        System.out.println(threeSum(nums3));
    }    
}

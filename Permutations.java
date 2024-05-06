import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> arr = new ArrayList<>(); // array list to store all permutations
        List<Integer> curr = new ArrayList<>(); // store the current permutation 
        boolean[] used = new boolean[nums.length]; // boolean array to keep track of whether each element in nums has been used in the current permutation
        generatePermutations(nums, used, curr, arr); // calling the function that backtracks and generates all permutations

        return arr;
    }
    public static void generatePermutations(int[] nums, boolean[] used, List<Integer> curr, List<List<Integer>> arr) {
        if (curr.size() == nums.length) { // if current permutation length is equal to nums it means all elements have been used and it can be added to arraylist
            arr.add(new ArrayList<>(curr));
            return;
        }

        for (int i = 0; i < nums.length; i++) { // loop over nums array
            if (!used[i]) { // if current element at index i has not been used in the current permutation
                curr.add(nums[i]); // add the element
                used[i] = true; // set to true
                generatePermutations(nums, used, curr, arr); // recursively call the function to continue generating permutations
                used[i] = false; // set to false to be used in other permutations
                curr.remove(curr.size() - 1); // remove the last element added to current permutation, backtracking to try the next candidate for the current position
            }
        }
    }   
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        int[] nums2 = {0,1};
        int[] nums3 = {1};

        System.out.println(permute(nums));
        System.out.println(permute(nums2));
        System.out.println(permute(nums3));
    } 
}

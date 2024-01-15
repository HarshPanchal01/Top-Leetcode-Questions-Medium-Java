import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combination_Sum {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates); // Sort the array
        // call the backtrack method
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }
    public static void backtrack(List<List<Integer>> result, List<Integer> currentList, int[] candidates, int remainingTarget, int start) {
        // if remaining target is 0 it means we have a combination of numbers that equals the target so add to the list
        if (remainingTarget == 0) {
            result.add(new ArrayList<>(currentList));
            return;
        }
        // loop through array
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > remainingTarget) {
                break; // If the candidate is too big, no need to continue
            }
            // add to current combination
            currentList.add(candidates[i]);
            // recursively call function again
            backtrack(result, currentList, candidates, remainingTarget - candidates[i], i);
            // backtrack by removing the last added element, allowing to explore other combinations
            currentList.remove(currentList.size() - 1);
        }
    }
    public static void main(String[] args) {
        int[] nums = {2,3,6,7};
        int target = 7;
        System.out.println(combinationSum(nums, target));

        int[] nums2 = {2,3,5};
        int target2 = 8;
        System.out.println(combinationSum(nums2, target2));

        int[] nums3 = {2};
        int target3 = 0;
        System.out.println(combinationSum(nums3, target3));
    }
}
public class Combination_Sum {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        
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
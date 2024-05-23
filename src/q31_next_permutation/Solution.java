package q31_next_permutation;

import java.util.Arrays;

/**
 * @author ：hezc
 * @date ：Created in 2024/5/21 19:54
 * @description：
 * @version: 1.0.0
 */
public class Solution {
    public void nextPermutation(int[] nums) {
        // 从右边找开始往前找一个数小于当前数，交换，再从小到大排序交换位置后的所有数
        if (nums == null || nums.length == 0) return;
        for (int i = nums.length - 1; i >= 1; i--) {
            int j = i - 1;
            if (nums[i] > nums[j]) {
                for (int k = nums.length - 1; k > j; k--) {
                    if (nums[k] > nums[j]) {
                        nums[j] = nums[k] + nums[j];
                        nums[k] = nums[j] - nums[k];
                        nums[j] = nums[j] - nums[k];
                        Arrays.sort(nums, j + 1, nums.length);
                        return;
                    }
                }

            }
        }
        Arrays.sort(nums);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1, 3, 2};
//        Arrays.sort(nums,1,3);
        solution.nextPermutation(nums);
//
        for (int num : nums) {
            System.out.printf(String.valueOf(num));
        }
//


    }
}

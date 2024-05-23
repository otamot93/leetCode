package q47_permutation_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ：hezc
 * @date ：Created in 2024/5/22 17:45
 * @description：不重复的排列
 * 通过生成字节序不同的排列
 * @version: 1.0.0
 */
public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<>();
        // 初始的list
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        result.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        int[] next = nums;
        while((next = nextPermutation(next)) != null){
            result.add(Arrays.stream(next).boxed().collect(Collectors.toList()));
        }
        return result;
    }

    int[] nextPermutation(int[] nums) {

        // 从后往前找
        for (int i = nums.length-1 ; i >= 1; i--) {
            int j = i -1;
            if (nums[i] > nums[j]) {
                // 从末尾到j找第一个比j大的值，交换
                for (int k = nums.length-1; k > j; k--) {
                    if(nums[k] > nums[j]) {
                        // 交换j和k位置的数
                        nums[j] = nums[j]+nums[k];
                        nums[k] = nums[j]-nums[k];
                        nums[j] = nums[j]-nums[k];
                        // 重新排序j后面的数
                        Arrays.sort(nums,i,nums.length);
                        return nums;
                    }
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> lists = solution.permuteUnique(new int[]{1, 2, 3});
        for (List<Integer> list : lists) {
            for (Integer num : list) {
                System.out.print(num);
            }
            System.out.println();
        }

    }
}

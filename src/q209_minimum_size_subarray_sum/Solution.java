package q209_minimum_size_subarray_sum;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

/**
 * @author ：hezc
 * @date ：Created in 2024/7/10 19:21
 * @description：
 * @version: 1.0.0
 */
public class Solution {

    // 遍历nums数组，使用队列存放可能满足达到条件的窗口数据，如果是达到了，尝试剔除队列中的数据，并在过程中记录最小值
    public int minSubArrayLen1(int target, int[] nums) {
        int i = 0;
        int sum = 0;
        int minSubArrayLen = nums.length + 1;
        Deque<Integer> deque = new ArrayDeque<>();
        while (i < nums.length) {
            sum += nums[i];
            deque.add(nums[i]);
            // 变换窗口
            while (sum >= target) {
                minSubArrayLen = Integer.min(minSubArrayLen, deque.size());
                sum -= deque.pop();
            }

            i++;
        }
        return minSubArrayLen == nums.length + 1 ? 0 : minSubArrayLen;
    }

    // 双指针滑动窗口
    public int minSubArrayLen(int target, int[] nums) {
        int result = nums.length+1;
        // 窗口开始位置
        int i = 0;
        int sum = 0;
        for(int j =0;j< nums.length;j++){
            sum+=nums[j];
            while(sum >= target){
                // 挪动窗口开始位置移动
                result = Integer.min(result,j-i+1);
                sum-=nums[i];
                i++;
            }
        }
        return result == nums.length+1 ? 0: result;
        
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 2, 3, 1, 2, 4, 3 };
        int minSubArrayLen = new Solution().minSubArrayLen(7, nums);
        System.out.println(minSubArrayLen);
        new HashMap().key
        Integer.m
    }
}

package q209_minimum_size_subarray_sum;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author ：hezc
 * @date ：Created in 2024/7/10 19:21
 * @description：
 * @version: 1.0.0
 */
public class Solution {

    public int minSubArrayLen(int target, int[] nums) {
        int  i = 0;
        int sum = 0;
        int minSubArrayLen = nums.length+1;
        Deque<Integer> deque = new ArrayDeque<>();
        while(i < nums.length ){
            sum += nums[i];
            deque.add(nums[i]);
            // 变换窗口
            while(sum >=target){
                minSubArrayLen = Integer.min(minSubArrayLen,deque.size());
                sum -= deque.pop();
            }

            i++;
        }
        return minSubArrayLen == nums.length+1? 0: minSubArrayLen;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,3,1,2,4,3};
        int minSubArrayLen = new Solution().minSubArrayLen(7,nums);
        System.out.println(minSubArrayLen);
    }
}

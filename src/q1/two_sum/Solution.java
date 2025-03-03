package q1.two_sum;

import java.util.HashMap;

/**
 * @author ：hezc
 * @date ：Created in 2024/7/15 19:57
 * @description：
 * @version: 1.0.0
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        // 存储两数和的另一个数做为key，当前数的index做为value
        HashMap<Integer,Integer> anotherNumbers = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(anotherNumbers.containsKey(nums[i])){
                return new int[]{i,anotherNumbers.get(nums[i])};
            }else{
                // 存储配对值，和当前index
                anotherNumbers.put(target-nums[i],i);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,4,3,0};
        int target = 0;
        int[] result = new Solution().twoSum(nums,target);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }

    }
}

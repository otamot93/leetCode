package q219_contains_duplicate_ii;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：hezc
 * @date ：Created in 2024/7/17 11:17
 * @description：也可以用滑动窗口
 * @version: 1.0.0
 */
public class Solution {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums==null || nums.length == 0){
            return false;
        }

        Map<Integer,Integer> numIndexHashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(numIndexHashMap.containsKey(nums[i]) && i-numIndexHashMap.get(nums[i]) <= k){
                return true;
            }
            numIndexHashMap.put(nums[i],i);
        }
        return false;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,1};
        int target = 3;
        boolean isContain = new Solution().containsNearbyDuplicate(nums,target);
        System.out.println(isContain);

    }
}

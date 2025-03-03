package q198_rob;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：hezc
 * @date ：Created in 2024/8/23 18:49
 * @description：
 * @version: 1.0.0
 */
public class Solution {
    Map<Integer,Integer> indexResult = new HashMap<>();
    public int rob(int[] nums) {
       return rob(nums,nums.length-1);
    }

    public int rob(int[] nums,int index){
        if(index == 0){
            return nums[0];
        }
        if( index == 1){
            return Integer.max(nums[0],nums[1]);
        }
        if(indexResult.containsKey(index)){
            return indexResult.get(index);
        }
        int robNumber = Integer.max(rob(nums,index-2)+ nums[index],rob(nums,index-1) );
        indexResult.put(index,robNumber);
        return robNumber;
    }

    public static void main(String[] args) {
        int robNum = new Solution().rob(new int[]{1,2,3,1});
        System.out.println(robNum);
    }
}

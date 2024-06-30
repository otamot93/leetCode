package q169_majority_element;

import java.util.Arrays;

/**
 * @author ：hezc
 * @date ：Created in 2024/6/21 21:56
 * @description：先排序，再遍历数数是否超过半数
 * @version: 1.0.0
 */
public class Solution {
    public int majorityElement(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        // 排序，保证相同元素是连续的
        Arrays.sort(nums);
        int targetNumberLength = 1;
        int lastNum = nums[0];

        for(int i=1;i<nums.length;i++){
            if(nums[i] == lastNum){
                targetNumberLength++;
                if(targetNumberLength > nums.length/2){
                    return nums[i];
                }
            }else{
                targetNumberLength = 1;
                lastNum = nums[i];
            }
        }
        // 如果存在多数元素，就不会走到
        return lastNum;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,2,2,4};
        int majorityNum =  new Solution().majorityElement(nums);
        System.out.println(majorityNum);
    }
}

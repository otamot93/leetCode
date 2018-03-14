package q16;

import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int[] numbers = new int[4];
        numbers[0] = 0;
        numbers[1] = 2;
        numbers[2] = 1;
        numbers[3] = -3;
        int finalResult = new Solution().threeSumClosest(numbers,1);
        System.out.println(finalResult);
    }
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        if(nums.length<3){
            return 0;
        }
        if(nums.length==3){
            return nums[0]+nums[1]+nums[2];
        }
        int finalResult = nums[0]+nums[1]+nums[2] ;
//        int sum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length-2 ; i++) {
            int left = i+1;
            int right = nums.length-1;
            while(left<right){
                int tempSum = nums[i]+nums[left]+nums[right];
                if(Math.abs(target-tempSum)<Math.abs(target-finalResult)){
                    finalResult = tempSum;
                }

                if(tempSum==target){
                    return target;
                }else if(tempSum<target){
                    left++;
                }else{
                    right--;
                }

            }
        }
        return finalResult;
    }
}

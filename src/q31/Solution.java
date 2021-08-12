package q31;

import java.util.Arrays;

public class Solution {
    public void nextPermutation(int[] nums) {
        //倒序遍历是否有符合要求的
        // 是否有下一个排列
        boolean isMatch = false;
        for (int i = nums.length-2; i >=0 ; i--) {
            if(nums[i]<nums[i+1]){
                //符合要求，则调换比它大的最小的一个
                int minIndex= findMinIndexInRange(nums, i + 1, nums[i]);
                nums[i] = nums[i]+nums[minIndex];
                nums[minIndex] = nums[i]-nums[minIndex];
                nums[i] = nums[i]-nums[minIndex];
                //范围内重排
                adjustRange(nums,i+1);
                isMatch = true;
                break;
            }

        }
        if(!isMatch){
            // 重排整个数组
            adjustRange(nums,0);
        }
    }

    /**
     * 在范围内搜索比target大的最小数值的下标,肯定存在
     * @param nums
     * @param startIndex
     * @param target
     */
    private int findMinIndexInRange(int[] nums,int startIndex, int target){
        int minIndex = startIndex;
        for (int i = startIndex+1; i < nums.length ; i++) {
            if(nums[i]>target && nums[i]<nums[minIndex]){
                minIndex = i;
            }
        }
        return minIndex;


    }

    /**
     * 从startIndex下标开始的范围内从小到大排序
     * @param nums
     * @param startIndex
     */
    private void adjustRange(int[] nums,int startIndex){
        // 调整最后一位，跳过
        if(startIndex == nums.length-1){
            return;
        }
        // 采用冒泡
        for (int i = startIndex; i < nums.length-1 ; i++) {
         for (int j=i+1;j<nums.length;j++){
             if(nums[i]>nums[j]){
                 //交换
                 nums[i] =nums[i]+nums[j];
                 nums[j] = nums[i]-nums[j];
                 nums[i]=nums[i]-nums[j];
             }
         }
        }
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{1,2,3};
        int[] nums = new int[]{1,3,2};
        new Solution().nextPermutation(nums);
        Arrays.stream(nums).forEach((num)->{
            System.out.println(num);
        });
    }
}

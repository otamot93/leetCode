package q34;

public class Solution {
    public static void main(String[] args) {
        int[] nums = new int[]{5,7,7,8,8,10};
        int target= 8;
        int[] result = new Solution().searchRange(nums,target);
        for (int i = 0; i <result.length ; i++) {
            System.out.println(result[i]);
        }
    }
    public int[] searchRange(int[] nums, int target) {
        int start = -1;
        int end = -1;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==target){
                if(start==-1){
                    start = i;
                    end = i;
                }else{
                    end = i;
                }
            }

        }
        return new int[]{start,end};
    }
}

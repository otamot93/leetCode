package q26;

public class Solution {
    public static void main(String[] args) {
        int[]  nums = new int[]{1,1,2,3,4,4,5,6};
        int result = new Solution().removeDuplicates(nums);
        System.out.println(result);
        for (int i: nums){
            System.out.println(i);
        }
    }
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0 || nums.length==1){
            return nums.length;
        }
        int all = 1;
        // 确保nums[i-1]不越界
        for (int i = 1; i <nums.length ; i++) {
            if(nums[i]!=nums[i-1]){
                nums[all] = nums[i];
                all++;
            }
        }
        return all;
    }
}

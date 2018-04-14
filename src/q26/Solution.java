package q26;

public class Solution {
    public static void main(String[] args) {
        int[]  nums = new int[]{1,1,2};
        int result = new Solution().removeDuplicates(nums);
        System.out.println(result);
        System.out.println(nums);
    }
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0 || nums.length==1){
            return nums.length;
        }
        int all = 1;
        int lastNumber = nums[0];
        for (int i = 1; i <nums.length ; i++) {
            if(nums[i]!=lastNumber){
                nums[all] = nums[i];
                all++;
                lastNumber = nums[i];
            }

        }
        return all;
    }
}

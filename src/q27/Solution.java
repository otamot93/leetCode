package q27;

public class Solution {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5};
        int result = new Solution().removeElement(nums,2);
        System.out.println(result);
    }
    public int removeElement(int[] nums, int val) {
        int all = 0;
        for (int i = 0; i <nums.length; i++) {
            if(nums[i] != val){
                if(i != all){
                    nums[all] = nums[i];
                }
                all++;
            }
        }
        return all;
    }
}

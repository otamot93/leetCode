package q35;

public class Solution {
    public static void main(String[] args) {
        int[] input = new int[]{1,3,5,6};
        int target = 2;
        int result = new Solution().searchInsert(input,target);
        System.out.println(result);
    }
    public int searchInsert(int[] nums, int target) {
        if(nums.length==0){
            return 0;
        }
        if(target<=nums[0]){
            return 0;
        }
        for (int i = 0; i <nums.length-1 ; i++) {
            if(target>nums[i] && target <=nums[i+1]){
                return i+1;
            }
        }
        return nums.length;
    }
}

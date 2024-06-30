package q55_jump_game;

/**
 * @author ：hezc
 * @date ：Created in 2024/6/26 18:06
 * @description：从后往前看，哪一个位置能跳到当前位置
 * @version: 1.0.0
 */
public class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length == 1){
            return true;
        }

        // 当前所在下标
        int current = nums.length-1;
        for (int i = current-1; i >=0 ; i--) {
            if(nums[i] + i >= current){
                current = i;
            }
        }

        return current == 0;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2};
        boolean result = new Solution().canJump(nums);
        System.out.println(result);
    }
}

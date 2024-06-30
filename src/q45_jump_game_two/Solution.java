package q45_jump_game_two;

/**
 * @author ：hezc
 * @date ：Created in 2024/6/28 09:57
 * @description：当前能走到最远的索引中统计哪个索引是下一次能走最远的
 * @version: 1.0.0
 */
public class Solution {
    public int jump(int[] nums) {
        if(nums.length == 1){
            return 0;
        }


        // 这次跳跃原始目标索引
        int eachMoveTargetIndex = Integer.min(nums[0],nums.length-1);

        // 这次跳跃过程中发现过程中索引还有能跳到最远的位置的索引
        int eachMoveFarthestIndex = nums[0];


        // 跳跃总数
        int sumStep = 0;
        for (int i = 1; i < nums.length; i++) {

            if(nums[i]+i > eachMoveFarthestIndex){
                eachMoveFarthestIndex = Integer.min(nums[i]+i,nums.length-1);
            }

            if(i == eachMoveTargetIndex){
                sumStep ++;
                eachMoveTargetIndex = eachMoveFarthestIndex;
            }

        }

        return sumStep;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        int minStep = new Solution().jump(nums);
        System.out.println(minStep);
    }

}

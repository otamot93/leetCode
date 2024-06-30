package q53_maximum_subarray;

/**
 * @author ：hezc
 * @date ：Created in 2024/5/27 16:21
 * @description：最大子数组和
 * @version: 1.0.0
 */
public class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length  ==1){
            return nums[0];
        }
        int tail = 0;
        // 连续增长的和
        int sum = nums[0];
        // 历史最大记录
        int result = nums[0];
        // 数字呈下降趋势后的和
        int downSum = 0;

        for (int i = 1; i < nums.length; i++) {
            // 前面子数组和为负数，且小于当前数，则抛弃前面的子数组
            if( sum+downSum < 0 && sum + downSum< nums[i]){
                // 先结算
                result = Integer.max(result,sum);
                tail = i;
                sum  = nums[i];
                downSum = 0;

                continue;
            }
            if(nums[i] > 0){
                if(tail == i-1){
                    // 连续上升趋势，移动尾部指针
                    tail = i;
                    sum += nums[i];
                    continue;
                }else{
                    // 之前有波动的
                    downSum+=nums[i];
                    if(downSum> 0){
                        // 波动到当前位置，总体是增加的
                        tail = i;
                        sum += downSum;
                        downSum = 0;
                    }
                }

            }else{
                // 下降趋势，累加downSum
                downSum += nums[i];
            }

        }
        return Integer.max(result,sum);
    }

    public int maxSubArray2(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,-3,5};
        Solution solution = new Solution();
        int sum = solution.maxSubArray2(nums);
        System.out.println(sum);
    }
}

package q238_product_of_array_except_self;

/**
 * @author ：hezc
 * @date ：Created in 2024/6/30 13:12
 * @description：除当前索引以外值的乘积，可以初始化left数组，left[i]即i左边的所有元素的乘积
 * right数组同理，需要注意left[0]和right[nums.length-1]为1
 * 索引i位置的乘积结果就为left[i]*right[i]
 * @version: 1.0.0
 */
public class Solution {

    public int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];

        int leftSum = 1;
        left[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            left[i] = leftSum;
            leftSum*=nums[i];

        }

        int rightSum = 1;
        right[nums.length-1] = 1;
        for (int i = nums.length-1; i >=0 ; i--) {
            right[i]  = rightSum;
            rightSum*=nums[i];
        }

        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = left[i]*right[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4};
        int[] result = new Solution().productExceptSelf(nums);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]+",");
        }
    }

}

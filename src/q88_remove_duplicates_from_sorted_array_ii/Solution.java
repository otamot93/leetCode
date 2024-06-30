package q88_remove_duplicates_from_sorted_array_ii;

/**
 * @author ：hezc
 * @date ：Created in 2024/6/6 10:02
 * @description：
 * 遍历数组过程中，通过变量sampleNumberFirstIndex记录号码第一次出现的索引，计算超过两个数。
 * 通过validNumberCount记录有效数量，为了有效数字写入对应索引位
 * @version: 1.0.0
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0 || nums.length == 1){
            return nums.length;
        }
        int all = 1;
        int sampleNumberFirstIndex = 0;
        for (int i = 1;i< nums.length;i++){
            // 相同且超过两个了
            if(nums[i] == nums[i-1] && i-sampleNumberFirstIndex >=2  ){
                continue;
            }
            // 数字不一样了

            if(nums[i] != nums[i-1]){
                sampleNumberFirstIndex = i;
            }
            // 之前出现过重复数字了
            if(all != i){
                nums[all] = nums[i];
            }
            all++;
        }
        return all;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,2,2,2,3};

        int result = new Solution().removeDuplicates(nums);
        System.out.println("count:"+result);

        for (int i: nums){
            System.out.print(i+",");
        }
    }
}

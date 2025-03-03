package q228_summary_ranges;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：hezc
 * @date ：Created in 2024/7/25 15:08
 * @description：
 * @version: 1.0.0
 */
public class Solution {
    public List<String> summaryRanges(int[] nums) {
        if(nums == null || nums.length == 0){
            return new ArrayList<>();
        }
        List<String> summary = new ArrayList<>();
        int start = 0;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] != nums[i-1]+1 ){
                // 写入范围
                if(i-1 == start){
                    summary.add(String.valueOf(nums[start]));
                }else{
                    summary.add(nums[start]+"->"+nums[i-1]);

                }
                start = i;
            }
        }
        if(start == nums.length-1){
            summary.add(String.valueOf(nums[start]));
        }else{
            summary.add(nums[start]+"->"+nums[nums.length-1]);
        }
        return summary;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1};
        List<String> summary = new Solution().summaryRanges(nums);
        for (int i = 0; i < summary.size(); i++) {
            System.out.println(summary.get(i));
        }
    }
}

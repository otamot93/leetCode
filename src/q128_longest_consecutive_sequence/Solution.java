package q128_longest_consecutive_sequence;

import java.util.*;

/**
 * @author ：hezc
 * @date ：Created in 2024/7/18 11:28
 * @description：
 * @version: 1.0.0
 */
public class Solution {
    public int longestConsecutive(int[] nums) {
//        Map<Integer, Set<Integer>> map = new HashMap<>();
//        int longest = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if(map.containsKey(nums[i])){
//                continue;
//            }
//            Set<Integer> set = new HashSet<>();
//            set.add(nums[i]);
//            if(map.containsKey(nums[i]-1)){
//                set.addAll(map.get(nums[i]-1));
//            }
//
//            if(map.containsKey(nums[i]+1)){
//                set.addAll(map.get(nums[i]+1));
//            }
//            map.put(nums[i],set);
//            longest = Integer.max(longest,set.size());
//
//            // 相关的数字全都更新集合
//            int right = nums[i]+1;
//            while(map.containsKey(right)){
//                map.put(right,set);
//                right++;
//            }
//            int left = nums[i]-1;
//            while(map.containsKey(left)){
//                map.put(left,set);
//                left--;
//            }
//        }
//        return longest;
        if(nums == null|| nums.length == 0){
            return 0;
        }
        Arrays.sort(nums);

        int start = 0;
        int current = 1;
        int longest = 0;
        int sameNumber = 0;
        while(current <= nums.length-1){
            if(nums[current] == nums[current -1]){
                sameNumber++;
            }
            if(nums[current] - nums[current-1] > 1){
                longest = Integer.max(longest,current - start-sameNumber);
                start = current;
                sameNumber = 0;
            }
            current++;
        }
        return Integer.max(longest,current-start-sameNumber);

    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,0,1};
        int longest = new Solution().longestConsecutive(nums);
        System.out.println(longest);
    }
}

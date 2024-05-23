package q46_permutations;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @author ：hezc
 * @date ：Created in 2024/5/22 19:38
 * @description：不重复的全排列
 * @version: 1.0.0
 */
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        if(nums == null || nums.length == 0) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        // 对nums排序
        Arrays.sort(nums);
        // 每一位数是否被使用
        boolean[] used = new boolean[nums.length];
        Deque<Integer> stack = new ArrayDeque<>();
        dfs(nums,0,used,stack,result);
        return result;
    }

    private void dfs(int[] nums,int depth,boolean[] used,Deque<Integer> stack,List<List<Integer>> result){
        // 排满了
        if(depth == nums.length){
            result.add(new ArrayList<>(stack));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(used[i]){
                continue;
            }
            used[i] = true;
            stack.push(nums[i]);
            dfs(nums,depth+1,used,stack,result);
            used[i] = false;
            stack.pop();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> permute = solution.permute(new int[]{1});
        for (List<Integer> list : permute) {
            for (Integer integer : list) {
                System.out.print(integer);
            }
            System.out.println();
        }

    }
}

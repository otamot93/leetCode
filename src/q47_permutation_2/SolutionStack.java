package q47_permutation_2;

import java.util.*;

/**
 * @author ：hezc
 * @date ：Created in 2024/5/23 18:45
 * @description：回溯剪枝法解决不重复的全排列
 * 通过判断重复项剪枝
 * @version: 1.0.0
 */
public class SolutionStack {

    public List<List<Integer>> permuteUnique(int[] nums) {
        if(nums == null || nums.length == 0) return new ArrayList<>();
        // 对数组进行排序
        Arrays.sort(nums);
        // 定义结果
        List<List<Integer>> result = new ArrayList<>();
        // 定义一个Stack，用于回溯排列
        Deque<Integer> stack = new ArrayDeque<>();
        // 定义一个长度为nums.length的数组记录元素使用情况
        boolean[] used = new boolean[nums.length];
        dfs(nums,0,stack,used,result);
        return result;
    }

    private void dfs(int[] nums, int depth, Deque<Integer> stack, boolean[] used, List<List<Integer>> result) {
        //stack排满的情况下，加入结果
        if(nums.length == depth){
            result.add(new ArrayList<>(stack));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // 当前位已经被使用了就跳过
            if(used[i]){
                continue;
            }
            // 当前位与前一位一致，且前一位未被使用，跳过，说明相同数字产生的排列已经产生了
            if(i > 0 && nums[i] == nums[i-1] && used[i-1] ==false){
                continue;
            }
            used[i] = true;
            stack.push(nums[i]);
            dfs(nums,depth+1,stack,used,result);
            stack.pop();
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        SolutionStack solution = new SolutionStack();
        List<List<Integer>> lists = solution.permuteUnique(new int[]{1, 1, 2});
        for(List<Integer> list :lists){
            for(Integer number:list){
                System.out.print(number);
            }
            System.out.println();
        }

    }
}

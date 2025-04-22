package q46_permutations;

import java.util.ArrayList;
import java.util.List;

public class Solution25 {
    public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];
        List<Integer> permutation = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        traceback(nums, used, permutation, res);
        return res;
    }

    private void traceback(int[] nums,boolean[] used,List<Integer> permutation,List<List<Integer>> res){
        for (int i = 0; i < nums.length; i++) {
            if(used[i]){
                // 被用过了，跳过
                continue;
            }
            used[i] = true;
            permutation.add(nums[i]);
            if(permutation.size() == nums.length){
                // 满足条件了，不回溯
                List<Integer> finalPermutation = new ArrayList<>();
                for(Integer number:permutation){
                    finalPermutation.add(number);
                }
                res.add(finalPermutation);
            }else{
                traceback(nums, used, permutation, res);
            }
            permutation.remove(permutation.size()-1);
            used[i] = false;
        }
    }
    
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        List<List<Integer>> res = new Solution25().permute(nums);

        for(List<Integer> permutation: res){
            for(Integer num: permutation){
                System.out.print(num+",");
            }
            System.out.println("");
        }
    }
}

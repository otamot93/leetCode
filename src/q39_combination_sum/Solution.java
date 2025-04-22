package q39_combination_sum;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();

        backtrace(candidates, target, res, combination, 0,0);

        return res;
    }

    public void backtrace(int[] candidates,int target,List<List<Integer>> res ,List<Integer> combination,int sum,int index){
        if(sum == target){
            res.add(new ArrayList<>(combination));
        }
        if(sum > target){
            return ;
        }
        for(int i=index;i< candidates.length;i++){
            // 如果加上这个数超了，就不要继续回溯了。
            combination.add(candidates[i]);
            backtrace(candidates, target, res, combination, sum+candidates[i],i);
            combination.remove(combination.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] candidates = new int[]{2,3,6,7};
        List<List<Integer>> res = new Solution().combinationSum(candidates, 7);
        for(List<Integer> combination: res){
            for(int num: combination){
                System.out.print(num+",");
            }
            System.out.println("");
        }
    }
}

package q77_combinations;

import java.util.ArrayList;
import java.util.List;


/**
 * 回溯
 */
public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<>();
        traceBack(list, new ArrayList<>(), n, k);
        return list;
    }

    private void traceBack(List<List<Integer>> combinations,List<Integer> combination,int n,int k){
        if(combination.size() == k){
            List<Integer> combinationFinal = new ArrayList<>();
            for (Integer num:combination) {
                combinationFinal.add(num);
            }
            combinations.add(combinationFinal);
            return;
        }
        int max= 0;
        if(combination.size()>0){
            max= combination.get(combination.size()-1);
        }
        for (int i = max+1; i <= n; i++) {
            // 若目前的combination+后面所有的数都不可能满足长度k，直接退出
            if(combination.size() +(n-i+1) <k){
                break;
            }

            combination.add(i);
            traceBack(combinations, combination, n, k);
            // 移除刚加入的元素
            combination.remove(combination.size()-1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> combinations = new Solution().combine(4, 4);
        for (int i = 0; i < combinations.size(); i++) {
            for (int j = 0; j < combinations.get(i).size(); j++) {
                System.out.print(combinations.get(i).get(j)+",");
            }
            System.out.println("");
        }
    }
}

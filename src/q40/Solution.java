package q40;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int[] src = new int[]{10,1,2,7,6,1,5};
        List<List<Integer>> lists = new Solution().combinationSum2(src, 8);
        System.out.println(lists);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i <candidates.length ; i++) {
            if (target == candidates[i]){//找到目标值
                List<Integer> list = new ArrayList<>();
                list.add(candidates[i]);
                lists.add(list);
            }else if(target>candidates[i]){//继续查找差值
                if(i == candidates.length-1){
                    break;
                }
                List<List<Integer>> findLists = this.combinationSum2(Arrays.copyOfRange(candidates,i+1,candidates.length),target-candidates[i]);
                if(findLists.size()>0){
                    for (List<Integer> list:findLists){
                        list.add(candidates[i]);
                    }
                    //合并
                    lists.addAll(findLists);
                }
            }
        }
    //第二层排序
        for (List<Integer> list:lists){
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
    }
        //去重
        HashSet h  = new HashSet(lists);
        lists.clear();
        lists.addAll(h);
        lists.sort((List<Integer>a ,List<Integer>b)->{
            int minLength = Math.min(a.size(),b.size());
            for (int i = 0;i<minLength;i++){
                if(a.get(i) == b.get(i)){
                    continue;
                }else{
                    return a.get(i)-b.get(i);
                }
            }
            return -1;
        });
        return lists;
    }
}

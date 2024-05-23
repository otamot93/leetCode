package q49_group_anagrams;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author ：hezc
 * @date ：Created in 2024/5/20 09:40
 * @description：相同字母异序词
 * @version: 1.0.0
 */
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // 排序后的单词和下标
        Map<String,List<String>> map = new HashMap<>();

        for (String str:strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String ordered = new String(chars);
            if(map.containsKey(ordered)){
                map.get(ordered).add(str);
            }else{
                List<String> list = new ArrayList<String>();
                list.add(str);
                map.put(ordered,list);
            }
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        Solution solution = new Solution();
        List<List<String>> lists = solution.groupAnagrams(strs);
        for (List<String> list : lists) {
            for (String str : list) {
                System.out.print(str);
            }
            System.out.println();
        }

    }
}

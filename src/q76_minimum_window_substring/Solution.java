package q76_minimum_window_substring;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    // 滑动窗口+使用两个hashmap比较是否满足
    public String minWindow(String s, String t) {
        if(s.length() < t.length()){
            return "";
        }
        // 构建target Hashmap
        Map<Character,Integer> targetCountMap = new HashMap<>();
        for(int i = 0;i<t.length();i++){
            targetCountMap.put(t.charAt(i),targetCountMap.getOrDefault(t.charAt(i),0)+1);
        }

        // 初始化窗口
        int left = 0;
        int right = 0;
        int minCount = Integer.MAX_VALUE;
        String result = "";
        Map<Character,Integer> windowCountMap = new HashMap<>();
        while(right < s.length()){
            // 已经满足的情况下，移动窗口左侧
            windowCountMap.put(s.charAt(right),windowCountMap.getOrDefault(s.charAt(right),0)+1);
            while(check(windowCountMap,targetCountMap)){
                if(right-left+1 < minCount){
                    minCount = right-left+1;
                    result = s.substring(left,right+1);
                }
                // 窗口左侧元素去除
                windowCountMap.put(s.charAt(left),windowCountMap.get(s.charAt(left))-1);
                left++;
            }
            right++;
        }
        return result;
    }

    boolean check(Map<Character,Integer> sMap,Map<Character,Integer> tMap){
        for(Character key:tMap.keySet()){
            if(tMap.get(key) > sMap.getOrDefault(key,0)){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String result = new Solution().minWindow("a", "aa");
        System.out.println(result);
    }
}

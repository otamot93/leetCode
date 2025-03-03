package q242_valid_anagram;

import java.util.Arrays;

/**
 * @author ：hezc
 * @date ：Created in 2024/7/14 09:36
 * @description：
 * @version: 1.0.0
 */
public class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        Arrays.sort(sArray);
        Arrays.sort(tArray);
        int i = 0;
        while(i < s.length()){
            if(sArray[i] != tArray[i]){
                return false;
            }
            i++;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "rat";
        String t = "cat";
        boolean isAnagram = new Solution().isAnagram(s,t);
        System.out.println(isAnagram);
    }
}

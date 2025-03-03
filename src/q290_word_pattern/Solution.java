package q290_word_pattern;

import java.util.HashMap;

/**
 * @author ：hezc
 * @date ：Created in 2024/7/13 14:49
 * @description：Solution
 * @version: 1.0.0
 */
public class Solution {
    public boolean wordPattern(String pattern, String s) {

        String[] sArray = s.split(" ");
        if(sArray.length != pattern.length()){
            return false;
        }
        // 初始化两个hash表
        HashMap<Character,String> pattern2s = new HashMap<>();
        HashMap<String,Character> s2pattern = new HashMap<>();

        for (int i = 0; i < pattern.length() ; i++) {
            char c = pattern.charAt(i);
            String word = sArray[i];
            if((pattern2s.containsKey(c) && !pattern2s.get(c).equals( word))
                    || s2pattern.containsKey(word) && !s2pattern.get(word).equals(c) ){
                return false;
            }

            pattern2s.put(c,word);
            s2pattern.put(word,c);
        }
        return true;

    }

    public static void main(String[] args) {
        String pattern = "abba";
        String s = "dog dog cat dog";
        boolean isWordPattern = new Solution().wordPattern(pattern,s);
        System.out.println(isWordPattern);
    }
}

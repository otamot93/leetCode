package q205_isomorphic_strings;

import java.util.HashMap;

/**
 * @author ：hezc
 * @date ：Created in 2024/7/12 19:50
 * @description：
 * @version: 1.0.0
 */
public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        HashMap<Character,Character> s2t = new HashMap<>();
        HashMap<Character,Character> t2s = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char charInS = s.charAt(i);
            char charInT = t.charAt(i);
            if(s2t.containsKey(charInS)){
                if(s2t.get(charInS) != charInT){
                    return false;
                }
            }else{
                s2t.put(charInS,charInT);
            }

            if(t2s.containsKey(charInT)){
                if(t2s.get(charInT) != charInS){
                    return false;
                }
            }else{
                t2s.put(charInT,charInS);
            }


        }
        return true;
    }

    public static void main(String[] args) {
        boolean isIsomorphic = new Solution().isIsomorphic("add","egg");
        System.out.println(isIsomorphic);
    }
}

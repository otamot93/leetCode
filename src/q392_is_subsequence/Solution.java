package q392_is_subsequence;

/**
 * @author ：hezc
 * @date ：Created in 2024/7/8 09:52
 * @description：
 * @version: 1.0.0
 */
public class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s == null ){
            return false;
        }
        if(s.length() == 0){
            return true;
        }

        if(t.length() < s.length()){
            return false;
        }

        int i = 0;
        int j = -1;
        while(i < t.length()){
            if(t.charAt(i)== s.charAt(j+1)){
                // 相等都往后移动
                i++;
                j++;
            }else{
                // 不想等s往后
                i++;
            }
            if(j == s.length()-1){
                break;
            }
        }
        return j == s.length() - 1 ;
    }

    public static void main(String[] args) {
        String s = "abc";
        String t  = "ahbgdc";
        boolean isSubSequence = new Solution().isSubsequence(s,t);
        System.out.println(isSubSequence);
    }
}

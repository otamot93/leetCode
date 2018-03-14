package q14;

public class Solution {
    public static void main(String[] args) {
        String[] strArr = {"abcdef","abcdea","abzz"};
        String target = new Solution().longestCommonPrefix(strArr);
        System.out.println(target);
    }
    public String longestCommonPrefix(String[] strs) {
        if(strs.length<1){
            return "";
        }
        String init = strs[0];
        for (int i = 1; i <strs.length ; i++) {
            if(init.length()==0){//没有公共前缀了
                break;
            }
            int newLength = Math.min(init.length(),strs[i].length());
            String temp = "";
            for (int j = 0; j <newLength ; j++) {
                if(init.charAt(j)==strs[i].charAt(j)){
                    temp+=init.charAt(j);
                }else{
                    break;
                }
            }
            init = temp;
        }

        return init;
    }
}

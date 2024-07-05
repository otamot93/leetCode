package q58_length_of_last_word;

/**
 * @author ：hezc
 * @date ：Created in 2024/7/2 09:24
 * @description：遍历数组计数，空格后的第一个数重新开始计数
 * @version: 1.0.0
 */
public class Solution {
    public int lengthOfLastWord(String s) {
        boolean lastCharIsBlankSpace = false;
        int length  = 0;
        for (int i=0;i< s.length();i++){
            char c  = s.charAt(i);
            if(c == ' '){
                lastCharIsBlankSpace = true;
            }else{
                // 上一个字符为空格
                if(lastCharIsBlankSpace == true){
                    length =1;
                }else{
                    length++;
                }
                lastCharIsBlankSpace = false;
            }
        }

        return length;
    }

    public static void main(String[] args) {
        String s = "luffy is still joyboy";
        int length = new Solution().lengthOfLastWord(s);
        System.out.println(length);
    }
}

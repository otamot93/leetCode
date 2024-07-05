package q125_valid_palindrome;

/**
 * @author ：hezc
 * @date ：Created in 2024/7/5 09:32
 * @description：
 * @version: 1.0.0
 */
public class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        // 预处理，去除非字母之外的内容
        char[] validChars = new char[s.length()];
        // 有效长度
        int validIndex = 0;

        for (int i = 0; i < s.length() ; i++) {
            char c = s.charAt(i);
//             Character.isLetterOrDigit()
            if((c >= 'a'  && c <= 'z') || (c >='0' && c <= '9')){
                validChars[validIndex] = c;
                validIndex++;
            }
        }

        // 回文判断
            // 双指针
        int start = 0;
        int end = validIndex - 1;
        while(start <= end){
            if(validChars[start] != validChars[end]){
                break;
            }
            start++;
            end--;
        }
        return start >= end;
    }

    public static void main(String[] args) {
        String s = "0P";
        boolean isPalindrome = new Solution().isPalindrome(s);
        System.out.println(isPalindrome);
    }
}

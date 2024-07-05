package q151_reverse_words_in_a_string;

/**
 * @author ：hezc
 * @date ：Created in 2024/7/3 09:25
 * @description：
 * @version: 1.0.0
 */
public class Solution {
    public String reverseWords(String s) {
        if(s == null || s.length() == 0){
            return s;
        }
        char[] reverseArr  = new char[s.length()];
        int reverseArrUseIndex = 0;
        int i = s.length()-1;

        int wordEnd = 0;
        boolean lastIsBlankSpace = true;
        while(i >= 0){
            char currentChar = s.charAt(i);
            if(currentChar == ' '){
                // 检测到单词开始
                if(lastIsBlankSpace == false){
                    // 写入反转数据
                    if(reverseArrUseIndex != 0){
                        reverseArr[reverseArrUseIndex] =  ' ';
                        reverseArrUseIndex++;
                    }
                    for (int j = i+1; j <= wordEnd; j++) {
                        reverseArr[reverseArrUseIndex] = s.charAt(j);
                        reverseArrUseIndex++;
                    }
                }
                lastIsBlankSpace = true;
            }else{
                if(lastIsBlankSpace == true){
                    // 检测到单词结尾
                    wordEnd = i;
                }
                if(i == 0){
                    if(reverseArrUseIndex != 0){
                        reverseArr[reverseArrUseIndex] =  ' ';
                        reverseArrUseIndex++;
                    }
                    // 写入反转数据
                    for (int j = i; j <= wordEnd; j++) {
                        reverseArr[reverseArrUseIndex] = s.charAt(j);
                        reverseArrUseIndex++;
                    }
                }
                lastIsBlankSpace = false;
            }
            i--;
        }
        return new String(reverseArr,0,reverseArrUseIndex).trim();
    }

    public static void main(String[] args) {
        String s = " the sky   is blue   ";
        String reverseStr = new Solution().reverseWords(s);
        System.out.println(reverseStr);
    }
}

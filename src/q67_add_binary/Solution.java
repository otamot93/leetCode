package q67_add_binary;

/**
 * @author ：hezc
 * @date ：Created in 2024/8/16 19:38
 * @description：
 * @version: 1.0.0
 */
public class Solution {
    public String addBinary(String a, String b) {
        int carry = 0;
        StringBuilder resultBuilder = new StringBuilder();
        int i = 0;
        while(i < a.length() || i < b.length()){

            int bitResult = 0;
            if(i < a.length()){
                bitResult += (a.charAt(a.length()-1-i) == '0'?0:1);
            }
            if(i < b.length()){
                bitResult += (b.charAt(b.length()-1-i) == '0'? 0:1);
            }
            resultBuilder.insert(0,(bitResult+carry)%2);

            carry = (bitResult+carry)/2;

            i++;
        }
        if(carry > 0){
            resultBuilder.insert(0,"1");
        }
        return resultBuilder.toString();
    }

    public static void main(String[] args) {

        System.out.println(new Solution().addBinary("1010","1011"));
    }
}

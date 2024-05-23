package q43_multiply_strings;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：hezc
 * @date ：Created in 2024/5/20 21:01
 * @description：
 * @version: 1.0.0
 */
public class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")){
            return "0";
        }

        // num2每一位的数与num1相乘，每位上的数保存到list
        List<List<Integer>> list = new ArrayList<>(100);
        // 从个位数开始
        for (int i = num2.length()-1; i >=0 ; i--) {
            char c = num2.charAt(i);
            // 将每位上的数置入list
            int index = num2.length()-1-i;

            int carry = 0;
            for (int j = num1.length()-1; j >=0 ; j--) {
                int result = (c-'0') * (num1.charAt(j)-'0')+carry;
                // 避免result是0，也把对应位的数组给建好
                if (list.size() - 1 < index) {
                    List<Integer> subList = new ArrayList<>();
                    subList.add((int) (result % 10));
                    list.add(subList);
                }else{
                    list.get(index).add((int) (result % 10));
                }
                carry = result/10;
                index++;
            }
            while(carry > 0){
                if (list.size() - 1 < index) {
                    List<Integer> subList = new ArrayList<>();
                    subList.add(carry % 10);
                    list.add(subList);
                }else{
                    list.get(index).add((int) (carry % 10));
                }
                carry /= 10;
                index++;
            }


        }

        // 将每位的数都相加得到字符串
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (List<Integer> list1 : list) {
            int result = 0;
            for (Integer num : list1) {
                result += num;
            }
            result +=carry;
            sb.insert(0,result %10);
            carry = result /10;
        }
        if(carry > 0){
            sb.insert(0,carry);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String multiply = solution.multiply("3866762897776739956", "15975363164662");
        System.out.println(multiply);


    }
}

package q224_basic_calculator;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.atomic.LongAdder;

/**
 * @author ：hezc
 * @date ：Created in 2024/7/23 16:38
 * @description：
 * @version: 1.0.0
 */
public class Solution {

    public int calculate(String s) {
        List<String> tokens = new ArrayList<>();
        getRPN(s,0,tokens);
        return evalRPN(tokens.toArray(new String[0]));
    }

    /**
     * 获取逆波兰式表达式
     * @param origin
     * @param index
     * @return
     */
    int getRPN(String origin,Integer index,List<String> result){

        // 到结束或者遇到 右括号返回
        Character lastOperator = null;
        // 处理大于1位的数字，拼接在一起
        boolean lastIsNumber = false;

        boolean hasNumber = false;
        for (int i = index; i < origin.length(); i++) {
            char c = origin.charAt(i);
            if(c == '+' || c == '-'){
                if(lastOperator != null){
                    result.add(String.valueOf(lastOperator));
                }
                lastOperator  = c;
                lastIsNumber = false;

                // 处理(-2 + 1)这种情况
                if(c == '-'  && !hasNumber){
                    result.add("0");
                }

                continue;
            }

            if(c == ')'){
                if(lastOperator != null){
                    result.add(String.valueOf(lastOperator));
                }
                return i++;
            }

            if(c == '('){
                int subIndex = getRPN(origin,i+1,result);
                i = subIndex;
                if(lastOperator != null){
                    result.add(String.valueOf(lastOperator));
                }
                lastOperator = null;
                lastIsNumber = false;
                hasNumber = true;
                continue;
            }

            if(c == ' '){
                lastIsNumber = false;
                continue;
            }

            if(lastIsNumber){
                result.set(result.size()-1,result.get(result.size()-1)+c);
            }else{
                result.add(String.valueOf(c));
            }
            lastIsNumber = true;
            hasNumber = true;
        }

        if(lastOperator != null){
            result.add(String.valueOf(lastOperator));
        }

        return origin.length();
    }

    public int evalRPN(String[] tokens) {
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];
            if("+".equals(token)){
                // 取出栈中的前两个数相加
                int firstNum = queue.pop();
                int secondNum = queue.pop();
                int result = firstNum+secondNum;
                queue.push(result);
            } else if ("-".equals(token)) {
                // 取出栈中的前两个数相减
                int firstNum = queue.pop();
                int secondNum = queue.pop();
                int result = secondNum - firstNum;
                queue.push(result);
            }else if("*".equals(token)){
                // 取出栈中的前两个数相乘
                int firstNum = queue.pop();
                int secondNum = queue.pop();
                int result = secondNum * firstNum;
                queue.push(result);
            }else if("/".equals(token)){
                // 取出栈中的两个数相除
                int firstNum = queue.pop();
                int secondNum = queue.pop();
                int result = secondNum / firstNum;
                queue.push(result);
            }else{
                queue.push(Integer.valueOf(token));
            }
        }
        return queue.pop();
    }

    public static void main(String[] args) {
        int result = new Solution().calculate("(7)-(0)+(4)");
        System.out.println(result);
    }
}

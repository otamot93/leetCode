package q150_evaluate_reverse_polish_notation;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 * @author ：hezc
 * @date ：Created in 2024/7/22 13:55
 * @description：
 * @version: 1.0.0
 */
public class Solution {
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
        String[] token = new String[]{"1","4","5","+","2","+","+","3","-","6","8","+","+"};
//        String[] token = new String[]{"1","2","-"};
        int result = new Solution().evalRPN(token);
        System.out.println(result);
    }


}

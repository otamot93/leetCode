package q20;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        Boolean isValid = new Solution().isValid("[]");
        System.out.println(isValid);
    }

    /**
     * https://leetcode.com/problems/valid-parentheses/discuss/9178/Short-java-solution
     * 智商压制
     * @param s
     * @return
     */
    public boolean isValid(String s){
        // 申明一个右侧括号对应左侧括号的集合
        Map<Character,Character>  map = new HashMap<>();
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');

        Deque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if(map.containsKey(c)){
                    if(deque.size() == 0){
                        return false;
                    }

                   char firstElement =  deque.pop();
                    // 如果栈顶数据不匹配，直接返回无效
                   if(map.get(c) != firstElement){
                       return false;
                   }
                }else{
                    deque.push(c);
                }
        }
        return deque.size() == 0;
    }
}

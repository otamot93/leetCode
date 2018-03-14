package q9;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        boolean isPalindrome = new Solution().isPalindrome(123);
        System.out.println(isPalindrome);
    }
    public boolean isPalindrome(int x){
        if(x<10 &&  x>=0){
            return true;
        }
        if(x <0){
            return false;
        }
        //能被10整除的也不是回文数字
        if(x%10 ==0){
            return false;
        }
        List<Integer> list = new ArrayList<>();
        //解析各个位的数字
        int operator = x;
        while(operator>0){
            int temp = operator%10;
            list.add(temp);
            operator = operator/10;
        }
        //逆序构造整形 1 2 3 4 5
        Integer[] arrlist = list.toArray(new Integer[list.size()]);
        int newNumber = 0;//todo 应该要改成double，不然构造的逆向数据可能超过int的最大数值
        for (int i = 0; i <=arrlist.length-1; i++) {
            newNumber = newNumber*10+arrlist[i];
        }
        return newNumber==x;
    }

    //更好的解法 https://leetcode.com/articles/palindrome-number/
}

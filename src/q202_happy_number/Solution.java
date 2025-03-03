package q202_happy_number;

import java.util.HashMap;

/**
 * @author ：hezc
 * @date ：Created in 2024/7/16 10:23
 * @description：
 * @version: 1.0.0
 */
public class Solution {
    public boolean isHappy(int n) {
        // 用set就好了
        // 定义一个HashMap，存放下一个计算的数，如果计算完的数在HashMap中已经有了，说明循环了，永远得不到结果
        HashMap<Integer,Integer> nextNumberHashMap = new HashMap<>();
        while(true){
            if(nextNumberHashMap.containsKey(n)){
                return false;
            }
            int origin = n;
            // 计算每一位的平方和
            int result = 0;
            while(n > 0){
                result += (n % 10) * (n % 10);

                n = n/10;
            }
            if(result == 1){
                return true;
            }
            nextNumberHashMap.put(origin,result);
            n = result;
        }
    }

    public static void main(String[] args) {
        int n = 2;
        boolean isHappy = new Solution().isHappy(n);
        System.out.println("isHappy:" + isHappy);

    }


}

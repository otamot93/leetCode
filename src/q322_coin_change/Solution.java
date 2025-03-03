package q322_coin_change;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author ：hezc
 * @date ：Created in 2024/9/2 19:45
 * @description：
 * @version: 1.0.0
 */
public class Solution {
    Map<Integer,Integer> map = new HashMap<>();
    public int coinChange(int[] coins, int amount) {
        if(amount == 0){
            return 0;
        }
        Arrays.sort(coins);
        if(amount < coins[0]){
            return -1;
        }
        if(map.containsKey(amount)){
            System.out.println(amount);
            return map.get(amount);
        }
        int result = Integer.MAX_VALUE;
        for (int i = coins.length-1; i >=0; i--) {
            if(coins[i] > amount){
                continue;
            }
            int leftCount = coinChange(coins,amount-coins[i]);
            if(leftCount != -1){
                result = Integer.min( 1 + leftCount,result);
            }
        }
        int count = result == Integer.MAX_VALUE ? -1: result;
        map.put(amount,count);
        return count;
    }

    public static void main(String[] args) {
        int i = new Solution().coinChange(new int[]{474,83,404,3}, 264);

        System.out.println(i);

    }
}

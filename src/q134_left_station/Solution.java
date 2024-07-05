package q134_left_station;

import java.util.Arrays;

/**
 * @author ：hezc
 * @date ：Created in 2024/7/1 09:41
 * @description：到达minIndex的位置能使得油量最紧缺
 * ，那么minIndex就应该是整个旅程的最后一站，相应的minIndex+1的位置就是起点。
 * sum>=0才能保证整个过程的供油量满足耗油量，即有解。
 * @version: 1.0.0
 */
public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0;
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        for(int i = 0; i < gas.length; i++){
            sum = sum + gas[i] - cost[i];
            if(sum < min && sum < 0){
                min = sum;
                minIndex = i;
            }
        }
        if(sum < 0) return -1;
        return (minIndex + 1 )%gas.length;
    }

    public static void main(String[] args) {
        int[] gas = new int[]{2,2,3,4};
        int[] cost = new int[]{2,2,3,4};
        int canComplete = new Solution().canCompleteCircuit(gas,cost);
        System.out.println(canComplete);
    }




}

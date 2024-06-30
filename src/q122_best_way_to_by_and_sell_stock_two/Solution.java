package q122_best_way_to_by_and_sell_stock_two;

/**
 * @author ：hezc
 * @date ：Created in 2024/6/25 14:07
 * @description：只要比前一天低，就买，第二天涨了就卖
 * @version: 1.0.0
 */
public class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 1){
            return 0;
        }

        int profit = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if(prices[i]  > min){
                // 卖
                profit +=(prices[i]-min);

                // 买
                min = prices[i];

            }else if(prices[i] < min){
                min = prices[i];
            }
        }

        return profit;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{1,2,3,4,5};
        int profit = new Solution().maxProfit(prices);
        System.out.println(profit);
    }
}

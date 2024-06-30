package q121_best_way_to_buy_and_sell_stock;

/**
 * @author ：hezc
 * @date ：Created in 2024/6/22 10:01
 * @description：
 * @version: 1.0.0
 */
public class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 1){
            return 0;
        }
        int minPrice = prices[0];
        int profit = 0;
        for (int i = 1;i < prices.length;i++){
            if(prices[i] <minPrice){
                // 合适的买入时机
                minPrice = prices[i];
            }else{
                profit = Integer.max(profit,prices[i]-minPrice);
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{6,1,4,5,6,7};
        int profit = new Solution().maxProfit(prices);
        System.out.println(profit);
    }
}

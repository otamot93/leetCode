package q135_candy;

public class Solution {
    // 左右侧规则取最大
    public int candy(int[] ratings) {
        
        int sum = 0;
        // 左侧规则，只有比左侧的大，才能分发更多的糖果，否则只能分发一个
        int[] leftResult =new int[ratings.length];
        for(int i = 0;i< ratings.length;i++){
            if(i == 0){
                leftResult[i] = 1;
            }else{
                leftResult[i] = ratings[i]> ratings[i-1]?leftResult[i-1]+1:1;
            }
        }

        // 右侧规则，只有比右侧的大，才能分发更多的糖果，否则只能发一个，结果则为符合两侧规则的最大值
        for(int i = ratings.length-1;i>=0;i--){
            int count;
            if(i == ratings.length -1){
                count = 1;
            }else{
                count = ratings[i]> ratings[i+1]?leftResult[i+1]+1:1;
            }
            leftResult[i] = Integer.max(count,leftResult[i]);
            sum += leftResult[i];
        }

        return sum;
    }
}

package q167_two_sum_two_input_array_is_sorted;

/**
 * @author ：hezc
 * @date ：Created in 2024/7/9 10:49
 * @description：
 * @version: 1.0.0
 */
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        while(i < j){
            if(numbers[i]+numbers[j] == target){
                return new int[]{i+1,j+1};
            }else if(numbers[i]+numbers[j] > target){
                j--;
            }else{
                i++;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{2,7,11,15};
        int[] result = new Solution().twoSum(numbers,18);
        for(int i:result){
            System.out.println(i);
        }
    }
}

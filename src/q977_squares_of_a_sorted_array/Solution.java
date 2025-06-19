package q977_squares_of_a_sorted_array;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public int[] sortedSquares(int[] nums) {
        // 额外申请一个队列
        Deque<Integer> queue = new ArrayDeque<>();
        // 最后的结果
        int[] result = new int[nums.length];
        int index = 0;
        for(int i= 0 ;i< nums.length;i++){
            int current = nums[i] * nums[i];
            if(nums[i] < 0){
                queue.push(current);
            }else{
                while(queue.size() > 0 && current > queue.peek()){
                    result[index] =queue.pop();
                    index++;
                }
                result[index] = current;
                index++;
            }
        }
        // 特殊情况，都是都是负数
        while(queue.size() > 0){
            result[index]  = queue.pop();
            index++;
        }
        return result;
    }

    // 双指针
    public int[] sortedSquares2(int[] nums){
        // 查找最后一个负数位置
        int negtive = -1;
        for(int i = 0;i< nums.length;i++){
            if(nums[i] < 0){
                negtive = i;
            }else{
                break;
            }
        }
        // 双指针归并
        int[] result = new int[nums.length];
        int index = 0;
        int i = negtive;
        int j = negtive+1;
        while(i >= 0|| j < nums.length){
            if(i < 0){
                result[index] = nums[j]*nums[j];
                index++;
                j++;
                continue;
            }
            if(j == nums.length){
                result[index] = nums[i] * nums[i];
                index++;
                i--;
                continue;
            }
            if(nums[i]* nums[i] > nums[j] * nums[j]){
                result[index] = nums[j]* nums[j];
                j++;
                index++;
            }else{
                result[index] = nums[i] * nums[i];
                i--;
                index++;
            }
        }
        return result;
    }


    // 双指针
    public int[] sortedSquares3(int[] nums){
        return null;
    }
}

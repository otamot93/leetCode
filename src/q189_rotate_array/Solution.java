package q189_rotate_array;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Solution {
    public void rotate(int[] nums, int k) {
        if(k % nums.length ==0){
            return;
        }

        // 转换为栈
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            deque.addLast(nums[i]);
        }
        
        // 取k%num.length次末尾的数值，放到队列前面
        for (int i = 0; i < k%nums.length; i++) {
            deque.addFirst(deque.pollLast());
        }

        // 放入数组
        for (int i = 0; i < nums.length; i++) {
            nums[i] = deque.pollFirst();
        }
    }

    public void rotateSample(int[] nums, int k) {
        if(k % nums.length ==0){
            return;
        }
        int[] numsNew = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numsNew[(i+k)%nums.length] = nums[i];
        }
        System.arraycopy(numsNew, 0, nums, 0, numsNew.length);
        
    }


    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        new Solution().rotateSample(nums, 2);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]+ ", ");
        }
    }
}

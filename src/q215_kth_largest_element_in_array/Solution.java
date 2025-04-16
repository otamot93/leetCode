package q215_kth_largest_element_in_array;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 思路:
 * 定义一个大小为k的堆，存放最大的k个数
 * 遍历数组，若堆大小小于k，存入数组
 * 若堆大小大于等于k，则取出最小的和当前元素比较，若当前元素较大，则当前元素放入堆中
 */
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a,Integer b){
                return a - b;
            }
        });

        for(int num: nums){
            if(priorityQueue.size() < k){
                priorityQueue.add(num);
            }else{
                int min = priorityQueue.poll();
                priorityQueue.add(Integer.max(min, num));
            }
        }
        
        return priorityQueue.peek();
    }
    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1,5,6,4};
        int k = 2;
        int kthLargest = new Solution().findKthLargest(nums, k);
        System.out.println(kthLargest);
    }
}

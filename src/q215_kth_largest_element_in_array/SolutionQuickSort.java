package q215_kth_largest_element_in_array;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * 快排，只排k测位置的
 */
public class SolutionQuickSort {
    
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        /**
         * 最k大的，即为n-k小的，快排逻辑为从小到大排的
         */
        return quickSort(nums, n-k, 0, n-1);
    }

    private int quickSort(int[] nums,int k,int left,int right){
        if(left == right){
            return nums[k];
        }
        int base = position(nums, left, right);
        if(base == k){
            return nums[k];
        }
        if(base < k){
            return quickSort(nums, k, base+1, right);
        }else{
            return quickSort(nums, k, left, base-1);
        }
    }

    private int position(int[] nums,int left,int right){
        // 随机基准
        int pivotIndex = new Random().nextInt(right - left + 1) + left; // 随机选择基准索引
        swap(nums, left, pivotIndex);
        int base = left;

        while(left < right){
            // 右指针左移，选择一个比base索引对应数据小的数据
            while(left < right && nums[base] <= nums[right]){
                right--;
            }
            while(left < right && nums[base] >= nums[left] ){
                left++;
            }
            // 找到了，交换两个数
            swap(nums, left, right);
        }
        // 交换base与left
        swap(nums, base, left);
        return left;
    }

    private void swap(int[] nums,int left,int right){
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{3,3,3,3,4,3,3,3,3};
        int k = 1;
        int kthLargest = new SolutionQuickSort().findKthLargest(nums, k);
        System.out.println(kthLargest);
    }
}

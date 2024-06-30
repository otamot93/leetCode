package q88_mege_sorted_array;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author ：hezc
 * @date ：Created in 2024/6/5 09:35
 * @description：
 * @version: 1.0.0
 */
public class Solution {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 存储弹出的元素
        Deque<Integer> temp = new ArrayDeque<>(m+n);
        int nums2Index = 0;
        for (int i = 0; i < nums1.length; i++) {
            // 小数组已经用完的情况
            if(nums2Index == nums2.length ){
                if( temp.size() > 0){
                    if(i < m){
                        temp.add(nums1[i]);
                    }
                    nums1[i] = temp.pop();
                }
                continue;
            }
            // 如果弹出队列里有值
            if(temp.size() > 0){
                if(i < m){
                    temp.add(nums1[i]);
                }
                if(nums2[nums2Index] < temp.getFirst()){
                    nums1[i] = nums2[nums2Index];
                    nums2Index ++;
                }else{
                    nums1[i] = temp.pop();
                }
            }else{
                if(i >= m){
                    nums1[i]  = nums2[nums2Index];
                    nums2Index++;
                } else if (nums2[nums2Index] < nums1[i]) {
                    temp.add(nums1[i]);
                    nums1[i]  = nums2[nums2Index];
                    nums2Index++;
                }

            }

        }

    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,4,5,6,0};
        int[] nums2 = new int[]{3};
        new Solution().merge(nums1,5,nums2,1);
        for (int i = 0; i < nums1.length; i++) {
            System.out.println(nums1[i]);
        }
    }
}

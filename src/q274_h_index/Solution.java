package q274_h_index;

import java.util.Arrays;

/**
 * @author ：hezc
 * @date ：Created in 2024/6/29 10:47
 * @description：排序下，在轮询到的索引位置，在hIndex小于引用数的情况下，
 * 反复判断是否满足有hIndex篇饮用不小于hIndex，满足hIndex++
 * @version: 1.0.0
 */
public class Solution {
    public int hIndex(int[] citations) {
        int hIndex = 0;
        Arrays.sort(citations);

        for (int i = 0; i < citations.length; i++) {
            while(hIndex < citations[i]){
                if(hIndex == citations.length){
                    break;
                }
                if(hIndex <= (citations.length-1-i)){
                    hIndex++;
                }else{
                    break;
                }
            }
        }
        return hIndex;
    }

    public static void main(String[] args) {
        int[] citations = new int[]{3,0,6,1,5};
        int hIndex = new Solution().hIndex(citations);
        System.out.println(hIndex);
    }
}

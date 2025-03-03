package q56_merge_intervals;

import java.util.Arrays;

/**
 * @author ：hezc
 * @date ：Created in 2024/7/26 10:21
 * @description：
 * @version: 1.0.0
 */
public class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length == 1){
            return intervals;
        }
        // 先排序
        sort(intervals);
        int  i = 0;
        int[][] result = new int[intervals.length][2];
        int num = 0;
        while(i < intervals.length){
            int start = intervals[i][0];
            int end  = intervals[i][1];
            int j = i+1;
            while(j < intervals.length && end >= intervals[j][0] ){
                end = Integer.max(end,intervals[j][1]);
                j++;
            }
            result[num] = new int[]{start,end};
            num++;
            i = j;
        }
        int[][] mergeIntervals = new int[num][2];
        System.arraycopy(result,0,mergeIntervals,0,num);
        return mergeIntervals;
    }

    private void sort(int[][] intervals){
        int i = intervals.length - 1;
        while(i >0){
            for (int j = 0; j < i ; j++) {
                if(intervals[j][0] > intervals[j+1][0]){
                    // swap
                    int[] temp = intervals[j];
                    intervals[j] = intervals[j+1];
                    intervals[j+1] = temp;
                }
            }
            i--;
        }

    }

    public static void main(String[] args) {
        int[][] intervals = new int[][]{{2,3},{4,5},{6,7},{1,10}};
        int[][] mergeIntervals = new Solution().merge(intervals);
        for (int i = 0; i < mergeIntervals.length; i++) {
            System.out.println(mergeIntervals[i][0]+","+mergeIntervals[i][1]);
        }
    }
}

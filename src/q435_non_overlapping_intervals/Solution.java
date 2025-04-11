package q435_non_overlapping_intervals;

import java.util.Arrays;

/**
 * 排序，相同起点，将较大的终点的排在后面
 * 遍历找到有重叠的区间，标记为去除（count++），如果前一个区间的范围很大，去除前一个区间（也就是right使用当前区间的终点）
 * 该逻辑为去除覆盖较多的逻辑
 */
public class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals == null || intervals.length == 0){
            return 0;
        }

        // sort
        Arrays.sort(intervals,(int[] intervalA,int[] intervalB)->{
            if(intervalA[0] < intervalB[0]){
                return -1;
            }else if(intervalA[0] > intervalB[0]){
                return 1;
            }else{
                return intervalA[1] <  intervalB[1] ? -1:(intervalA[1] >  intervalB[1]?1:0);
            }
        });

        int right = intervals[0][1];
        int count = 0;
        
        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] < right){
                // 有重叠
                if(intervals[i][1]< right){
                    // 前一个的范围太大了，把前一个移除了
                    right = intervals[i][1];
                }
                count++;
            }else{
                right = intervals[i][1];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] interval = new int[][]{{-52,31},{-73,-26},{82,97},{-65,-11},{-62,-49},{95,99},{58,95},{-31,49},{66,98},{-63,2},{30,47},{-40,-26}};
        int eraseCount = new Solution().eraseOverlapIntervals(interval);
        System.out.println(eraseCount);
    }
}

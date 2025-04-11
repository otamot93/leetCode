package q435_non_overlapping_intervals;

import java.util.Arrays;


/**
 * 排序，以右端点排序
 * 遍历，如果没有重叠，则+1
 * 该逻辑为留下没有重叠的逻辑
 */
public class SolutionAfterUD {
        public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals == null || intervals.length == 0){
            return 0;
        }

        // sort
        Arrays.sort(intervals,(int[] intervalA,int[] intervalB)->{
            return intervalA[1] - intervalB[1];
        });

        int right = intervals[0][1];
        // 表示能留下的数量
        int count = 1;
        
        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] >= right){
                count++;
                right = intervals[i][1];
            }
        }
        return intervals.length-count;
    }

    public static void main(String[] args) {
        int[][] interval = new int[][]{{-52,31},{-73,-26},{82,97},{-65,-11},{-62,-49},{95,99},{58,95},{-31,49},{66,98},{-63,2},{30,47},{-40,-26}};
        int eraseCount = new SolutionAfterUD().eraseOverlapIntervals(interval);
        System.out.println(eraseCount);
    }
}

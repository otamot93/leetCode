package q452_find_min_arrow_shots;
// 合并区间，区间数量即为最少箭数,需要使用区间交集，交集的地方射箭

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class Solution {
    public int findMinArrowShots(int[][] points) {
        if(points == null){
            return 0;
        }
        if(points.length == 1){
            return 1;
        }
        // sort
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] a,int[] b){
                    return Integer.compare(a[0], b[0]);
            }
        });
        int left = points[0][0];
        int right = points[0][1];
        int count = 1;
        for(int[] point:points){
            if(point[0]<= right && point[0] >= left){
                // 有交集
                left = Integer.max(left, point[0]);
                right = Integer.min(right, point[1]);
            }else{
                left=point[0];
                right = point[1];
                count++;
            }
        }

        return count;
    }


    public static void main(String[] args) {
        int[][] points = new int[][]{{1,2},{2,3},{3,4},{4,5}};
        int minArrowShots = new Solution().findMinArrowShots(points);
        System.out.println(minArrowShots);
    }
}

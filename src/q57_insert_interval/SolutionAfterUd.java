package q57_insert_interval;

import java.util.ArrayList;
import java.util.List;

public class SolutionAfterUd {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // 定义结果List
        List<int[]> result = new ArrayList<>();
        int left = newInterval[0];
        int right = newInterval[1];
        boolean place = false;// 是否已经放置过
        for(int[] interval :intervals){
            
            if(interval[0]> right){
                // 插入区间在左边，且无重叠
                if(!place){
                    // 先把重叠区间加入
                    result.add(new int[]{left,right});
                    place = true;
                }
                result.add(interval);
            }else if(interval[1] < left){
                // 还没到插入的区间
                result.add(interval);
            }else{
                // 有重叠
                left = Integer.min(left, interval[0]);
                right = Integer.max(right,interval[1]);
            }
        }

        // 如果还未放置，就放入结果
        if(!place){
            result.add(new int[]{left,right});
        }

        int[][] finalResult = new int[result.size()][2];
        for(int i=0;i< result.size();i++){
            finalResult[i] = result.get(i);
        }
        return finalResult;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,3},{6,9}};
        int[] newInterval = {2,5};
        int[][] result = new SolutionAfterUd().insert(intervals, newInterval);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j]+",");
            }
            System.out.println("");
        }
    }
}

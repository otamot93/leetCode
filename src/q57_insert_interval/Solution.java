package q57_insert_interval;

public class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // 先按开始下标进行排查插入为一个数组
        int total = intervals.length+1;
        int[][] mergeArr = new int[total][];

        int count = 0;
        for (int i = 0; i < intervals.length; i++) {
            if(newInterval[0] < intervals[i][0]){
                mergeArr[count] = newInterval;
                count++;
                // 剩下的直接插入
                for (int j = i; j < intervals.length; j++) {
                    mergeArr[count] = intervals[j];
                    count++;
                }
                break;
            }else{
                mergeArr[count] = intervals[i];
                count++;
            }
        }
        // newInterval的开始是最大的
        if(count != total){
            mergeArr[count] = newInterval;
        }

        // 循环、合并分区
        int[][] middleResult = new int[total][];
        count = 0;
    
        for (int i = 0; i < mergeArr.length; i++) {
            // 如果发现和后面的区间有冲突
            if(i != mergeArr.length-1 && !(mergeArr[i][1] < mergeArr[i+1][0])){
                int min = Integer.min(mergeArr[i][0], mergeArr[i+1][0]);
                int max = Integer.max(mergeArr[i][1], mergeArr[i+1][1]);
                int j = i+2;
                while(j< mergeArr.length && max >= mergeArr[j][0]){
                    max = Integer.max(max,mergeArr[j][1]);
                    j++;
                }
                i = j-1;
                middleResult[count++] = new int[]{min,max}; 
            }else{
                middleResult[count++] = mergeArr[i];
            }
        }
        int[][] finalReulst = new int[count][];
        System.arraycopy(middleResult, 0, finalReulst, 0, count);


        return finalReulst;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,5}};
        int[] newInterval = {5,7};
        int[][] result = new Solution().insert(intervals, newInterval);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j]+",");
            }
            System.out.println("");
        }
    }
}

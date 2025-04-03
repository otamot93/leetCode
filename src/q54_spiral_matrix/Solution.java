package q54_spiral_matrix;

import java.util.ArrayList;
import java.util.List;


public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        // 未处理边界

        int total = (matrix[0].length) * matrix.length;
        int left =0;
        int right = matrix[0].length-1;
        int up = 0;
        int down = matrix.length-1;

        List<Integer> result = new ArrayList<>();
        result.add(matrix[0][0]);

        // 起始坐标
        int x = 0,y=0;
        // 起始方向
        int currentDirector = -1;

        while(result.size() < total){
            // 获取下一个方向 0为右，1为下，2为左 3为右
            currentDirector = (currentDirector+1)%4;
            if(currentDirector == 0){
                while(++y <= right){
                    result.add(matrix[x][y]);
                }
                up++;
                y=right;
            }

            if(currentDirector == 1){
                while(++x <= down){
                    result.add(matrix[x][y]);
                }
                right--;
                x=down;
            }
            if(currentDirector == 2){
                while(--y >= left){
                    result.add(matrix[x][y]);
                }
                down--;
                y=left;
            }

            if(currentDirector == 3){
                while(--x >= up){
                    result.add(matrix[x][y]);
                }
                left++;
                x=up;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16},{17,18,19,20},{21,22,23,24}};
        List<Integer> spiralOrder = new Solution().spiralOrder(matrix);

        for (int i : spiralOrder) {
            System.out.println(i);
        }
    }
}

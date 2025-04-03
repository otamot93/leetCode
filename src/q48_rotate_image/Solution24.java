package q48_rotate_image;

import java.util.ArrayList;
import java.util.List;

/**
 * 更优解法，水平翻转、对角线翻转
 */
public class Solution24 {

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
            // 获取下一个方向 0为右，1为下，2为左 3为上
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


    // 旋转图像
    public void rotate(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return;
        }

        List<Integer> ordered = this.spiralOrder(matrix);

        // 起始坐标
        int x = 0,y=matrix[0].length-1;
        // 起始方向,向右 3
        int currentDirector = 0;

        int left =0;
        int right = matrix[0].length-1;
        int up = 0;
        int down = matrix.length-1;

        matrix[x][y]= ordered.get(0);
        int i = 1;
        while(i< ordered.size()){
            // 获取下一个方向 0为右，1为下，2为左 3为上
            currentDirector = (currentDirector+1)%4;
            if(currentDirector == 0){
                while(++y <= right){
                    matrix[x][y] = ordered.get(i);
                    i++;
                }
                up++;
                y=right;
            }

            if(currentDirector == 1){
                while(++x <= down){
                    matrix[x][y] = ordered.get(i);
                    i++;
                }
                right--;
                x=down;
            }
            if(currentDirector == 2){
                while(--y >= left){
                    matrix[x][y] = ordered.get(i);
                    i++;
                }
                down--;
                y=left;
            }

            if(currentDirector == 3){
                while(--x >= up){
                    matrix[x][y] = ordered.get(i);
                    i++;
                }
                left++;
                x=up;
            }
        }
        
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        new Solution24().rotate(matrix);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]+",");
            }
            System.out.println("");
        }
    }

}

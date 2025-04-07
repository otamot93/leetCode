package q73_set_zeros;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public void setZeroes(int[][] matrix) {
        if(matrix ==  null || matrix.length==0 || matrix[0].length == 0){
            return;
        }
        List<Integer> rows =new ArrayList();
        List<Integer> cols = new ArrayList();
        // 记录存在0的行列
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j]==0){
                    rows.add(i);
                    cols.add(j);
                }

            }
        }
        // 修改为0
        for(int i: rows){
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = 0;
            }
        }
        for(int j:cols){
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][j] = 0;
            }
        }
    }
    public static void main(String[] args) {
        int[][] matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        new Solution().setZeroes(matrix);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]+",");
            }
            System.out.println("");
        }
    }
}

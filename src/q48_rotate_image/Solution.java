package q48_rotate_image;

/**
 * @author ：hezc
 * @date ：Created in 2024/5/18 13:27
 * @description：翻转图片(数组)
 * 遍历每一行，竖着放到列（从后往前）
 * @version: 1.0.0
 */

public class Solution {
    public void rotate(int[][] matrix) {
        // 拷贝一份
        int[][] origin = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                origin[i][j] = matrix[i][j];
            }
        }
        int currentColumn = origin[0].length - 1;
        for (int i = 0; i < origin.length; i++) {
            for (int j = 0; j < origin[i].length; j++) {
                matrix[j][currentColumn] = origin[i][j];
            }
            currentColumn -- ;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] origin = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        solution.rotate(origin);

        for (int i = 0; i < origin.length; i++) {
            for (int j = 0; j < origin[i].length; j++) {
                System.out.print(origin[i][j]);
            }
            System.out.println();
        }
    }
}

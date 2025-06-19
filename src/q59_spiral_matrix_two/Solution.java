package q59_spiral_matrix_two;

public class Solution {
    // 根据方向填写，直到到了边界或者已被填写则变换方向
    public int[][] generateMatrix(int n) {
        int[][] directors = {{0,1},{1,0},{0,-1},{-1,0}};
        int[][] result = new int[n][n];
        // 初始化数据
        int x = 0;int y = 0;
        int director = 0;
        int count = 0;
        for(int i = 1;i<= n * n ;i++){
            result[x][y] = i;
            int nextX = x+directors[director][0];
            int nextY = y+directors[director][1];
            // 判断是否越界或者已经被填写
            if(nextX>=n || nextX < 0 || nextY >= n || nextY < 0 || result[nextX][nextY] > 0 ){
                director = (director+1)%4;
                nextX = x+directors[director][0];
                nextY = y+directors[director][1];
            }
            x = nextX;
            y = nextY;
        }

        return result; 
    }
}

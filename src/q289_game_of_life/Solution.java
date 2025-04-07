package q289_game_of_life;

import java.util.Arrays;

public class Solution {

    public  int[][] deepCopyIntArray(int[][] original) {
        if (original == null) {
            return null;
        }
        int[][] result = new int[original.length][];
        for (int i = 0; i < original.length; i++) {
             if (original[i] == null) {
                result[i] = null;
                continue;
            }
            result[i] = new int[original[i].length];
            // 使用 System.arraycopy 复制内层数组
            System.arraycopy(original[i], 0, result[i], 0, original[i].length);
        }
        return result;
    }
    public void gameOfLife(int[][] board) {
        int[][] originArray = deepCopyIntArray(board);
        for (int i = 0; i < originArray.length; i++) {
            for (int j = 0; j < originArray[i].length; j++) {
                // 获取周边活细胞数量
                int liveNumber = this.getLiveNumber(originArray, i, j);
                if(originArray[i][j] == 1 && liveNumber< 2){
                    board[i][j] = 0;
                    continue;
                }
                if( originArray[i][j] == 1 &&  liveNumber <=3){
                    board[i][j] = 1;
                    continue;
                }
                 if(originArray[i][j] == 1 && liveNumber >3){
                    board[i][j] = 0;
                    continue;
                }
                
                if(originArray[i][j] == 0 && liveNumber ==3){
                    board[i][j] = 1;
                    continue;
                }

            }
        }
    }
    public int getLiveNumber(int[][] board,int i,int j) {
        int preRow = Integer.max(0, i-1);
        int nextRow = Integer.min(board.length-1,i+1);
        int preColumn = Integer.max(0, j-1);
        int nextColumn = Integer.min(j+1, board[i].length-1);
        int total = 0;
        for(int m = preRow;m<=nextRow;m++){
            for(int n = preColumn;n <= nextColumn;n++){
                if(board[m][n] == 1 ){
                    if( m== i && n == j){
                        continue;
                    }
                    total++;
                }
            }
        }
        return total;
    }

    public static void main(String[] args) {
        int[][] board = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        new Solution().gameOfLife(board);
        for(int i=0;i< board.length;i++){
            for(int j=0;j< board[i].length;j++){
                System.out.print(board[i][j]+",");
            }
            System.out.println("");
        }

    }

}

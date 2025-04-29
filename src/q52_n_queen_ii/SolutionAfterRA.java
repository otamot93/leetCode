package q52_n_queen_ii;

import java.util.ArrayList;
import java.util.List;

public class SolutionAfterRA {
    public int totalNQueens(int n) {
        // 定义列，两个方案的斜线是否已经被占用
        boolean[] columns = new boolean[n];
        boolean[] diagonals1 = new boolean[n+n];
        boolean[] diagonals2 = new boolean[n+n];
        
        int count = backTrace(n, 0,columns,diagonals1,diagonals2);
        return count;
    }

    private int backTrace(int n,int rowId,boolean[] columns,boolean[] diagonals1,boolean[] diagonals2){
        if(rowId == n){
            return 1;
        }
        int count = 0;
        for(int col=0;col < n;col++ ){
            
            // 判断当前点位是否已经会被攻击
            if(columns[col]){
                continue;
            }
            int diagonal1 = rowId+col;
            if(diagonals1[diagonal1]){
                continue;
            }

            int diagonal2 = rowId-col+n;
            if(diagonals2[diagonal2]){
                continue;
            }
            // 这一行使用当前点位
            columns[col] = true;
            diagonals1[diagonal1] = true;
            diagonals2[diagonal2] = true;
            count+= backTrace(n, rowId+1, columns, diagonals1, diagonals2);
            
            // 回溯
            columns[col] = false;
            diagonals1[diagonal1] = false;
            diagonals2[diagonal2] = false;
        }

        return count;
    }

    public static void main(String[] args) {
        int total = new SolutionAfterRA().totalNQueens(4);
        System.out.println(total);
    }


}

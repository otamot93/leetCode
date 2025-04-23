package q52_n_queen_ii;

import java.util.ArrayList;
import java.util.List;

/**
 * 回溯
 */
public class Solution {

    public int totalNQueens(int n) {
        // 初始化已经使用或会被攻击的格子
        String[][] used = new String[n][n];
        List<List<String>> res = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        backTrace(n, 0, used, temp, res);
        return res.size();
    }

    private void backTrace(int n,int rowId,String[][] used,List<String> temp,List<List<String>> res){
        if(rowId >= n){
            res.add(temp);
            return;
        }

        for(int col = 0;col < n;col++){
            // 当前点位没有在攻击范围内
            if(used[rowId][col] == null){
                temp.add(rowId+"-"+col);
                // 添加攻击范围
                attackAreaAdd(rowId, col,n, used, rowId+"-"+col);
                backTrace(n, rowId+1, used, temp, res);
                // 去除攻击范围
                attackAreaDelete(rowId, col, n, used, rowId+"-"+col);
                // 去除当前点位信息
                temp.remove(temp.size()-1);
            }
        }
    }

    private void attackAreaAdd(int x,int y,int n,String[][] used,String value){
        int[][] directors = new int[][]{{0,1},{0,-1},{1,0},{-1,0},{1,1},{-1,-1},{-1,1},{1,-1}};

        for(int[] director: directors){
            int x_temp = x; int y_temp = y;
            while(x_temp >=0 && x_temp <n && y_temp>=0 && y_temp < n){
                if(used[x_temp][y_temp] == null){
                    used[x_temp][y_temp] = value;
                }
                x_temp += director[0];
                y_temp += director[1];
            }
        }
    }

    private void attackAreaDelete(int x,int y,int n,String[][] used,String value){
        int[][] directors = new int[][]{{0,1},{0,-1},{1,0},{-1,0},{1,1},{-1,-1},{-1,1},{1,-1}};

        for(int[] director: directors){
            int x_temp = x; int y_temp = y;
            while(x_temp >=0 && x_temp <n && y_temp>=0 && y_temp < n){
                if(value.equals(used[x_temp][y_temp])){
                    used[x_temp][y_temp] = null;
                }
                x_temp += director[0];
                y_temp += director[1];


            }
        }
    }

    public static void main(String[] args) {
        int total = new Solution().totalNQueens(4);
        System.out.println(total);
    }

}

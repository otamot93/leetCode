package q36_valid_suduku;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        // 定义行校验
        Set[] rowValidation = new Set[9];
        for (int i = 0; i < rowValidation.length; i++) {
            rowValidation[i] = new HashSet<>();
        }
        // 定义列校验
        Set[] columnValidation = new Set[9];
        for (int i = 0; i < columnValidation.length; i++) {
            columnValidation[i]=new HashSet<>();
        }

        // 定义3*3区域校验hashmap
        Set[][]  area = new Set[3][3];
        for (int i = 0; i < area.length; i++) {
            for (int j = 0; j < area.length; j++) {
                area[i][j] = new HashSet<>();
            }
        }

        for (int i = 0; i < board.length; i++) {
  
            for(int j = 0; j< board[i].length;j++){
                if(board[i][j] == '.'){
                    continue;
                }
                if(rowValidation[i].contains(board[i][j])){
                    return false;
                }else{
                    rowValidation[i].add(board[i][j]);
                }
                
                if(columnValidation[j].contains(board[i][j])){
                    return false;
                }else{
                    columnValidation[j].add(board[i][j]);
                }

                // area validate
                int areaRowId = i/3;
                int areaColId = j/3;

                if(area[areaRowId][areaColId].contains(board[i][j])){
                    return false;
                }else{
                    area[areaRowId][areaColId].add(board[i][j]);
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        char[][] board = {
            {'1', '2', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.'}
        };
        boolean validSudoku = new Solution().isValidSudoku(board);
        System.out.println(validSudoku);
    }
}

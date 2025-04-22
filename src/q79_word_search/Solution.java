package q79_word_search;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public boolean exist(char[][] board, String word) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                // 寻找开始搜索的位置
                if(board[i][j] == word.charAt(0)){
                    // 使用一个二维数组标记是否已经走过了
                    boolean[][] searched = new boolean[board.length][board[0].length];
                    searched[i][j] = true;
                    StringBuilder temp = new StringBuilder();
                    List<String> res = new ArrayList<>();
                    temp.append(word.charAt(0));
                    backsearch(board,word, searched, i, j, 0,temp,res);
                    if(res.contains(word)){
                        return true;
                    }

                }
            }
        }

        return false;
    }

    private void backsearch(char[][] board,String word,boolean[][] searched,int x,int y, int index,StringBuilder temp,List<String> res ){

        if(board[x][y] != word.charAt(index) ){
            return;
        }

        if(index == word.length()-1){
            res.add(temp.toString());
            return;
        }

        // 上下左右查找
        if(inBoard(board, x+1, y) && !searched[x+1][y]){
            searched[x+1][y] = true;
            temp.append(board[x+1][y]);
            backsearch(board, word, searched, x+1, y, index+1, temp, res);
            searched[x+1][y] = false;
            temp.deleteCharAt(temp.length()-1);
        }
        if(inBoard(board, x-1, y) && !searched[x-1][y]){
            searched[x-1][y] = true;
            temp.append(board[x-1][y]);
            backsearch(board, word, searched, x-1, y, index+1, temp, res);
            searched[x-1][y] = false;
            temp.deleteCharAt(temp.length()-1);
        }
        if(inBoard(board, x, y-1) && !searched[x][y-1]){
            searched[x][y-1] = true;
            temp.append(board[x][y-1]);
            backsearch(board, word, searched, x, y-1, index+1, temp, res);
            searched[x][y-1] = false;
            temp.deleteCharAt(temp.length()-1);
        }
        if(inBoard(board, x, y+1) && !searched[x][y+1]){
            searched[x][y+1] = true;
            temp.append(board[x][y+1]);
            backsearch(board, word, searched, x, y+1, index+1, temp, res);
            searched[x][y+1] = false;
            temp.deleteCharAt(temp.length()-1);
        }

        
    }

    private boolean inBoard(char[][] board,int x,int y){
        if(x < 0 || x > (board.length-1)){
            return false;
        }
        if(y < 0|| y > (board[0].length-1)){
            return false;
        }
        return true;
    }


    public static void main(String[] args) {
        char[][] board = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        boolean  exist = new Solution().exist(board, "ABCCEF");
        System.out.println(exist);
    }
}

package q74_search_a_2d_matrix;

/**
 * 二分
 * todo 行也修改为二分查找
 */
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        return searchMatrix(matrix, target,0,matrix.length-1);
    }

    private boolean searchMatrix(int[][] matrix, int target,int rowId1,int rowId2) {
            if(rowId2 < rowId1){
                return false;
            }
            if(rowId1 == rowId2){
                for (int i = 0; i < matrix[rowId1].length; i++) {
                    if(matrix[rowId1][i] == target){
                        return true;
                    }
                    if(matrix[rowId1][i] > target){
                        break;
                    }
                }
                return false;
            }
                // 取中间行
        int mid = (rowId2+rowId1)/2+1;
        if(target > matrix[mid][0]){
            return searchMatrix(matrix, target,mid,rowId2);
        }
        if(target < matrix[mid][0]){
            return searchMatrix(matrix, target,rowId1,mid-1);
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        boolean searched = new Solution().searchMatrix(matrix, 61);
        System.out.println(searched);
    }
}

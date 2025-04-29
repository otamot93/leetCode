package q74_search_a_2d_matrix;

public class SolutionAfterReadAnswer {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowId = searchMatrixRow(matrix, target);
        if(rowId <= -1){
            return false;
        }
        return searchMatrixColumn(matrix,target,rowId);
    }

    private int searchMatrixRow(int[][] matrix,int target) {
            int low = 0; int high = matrix.length-1;
            while(low < high){
                int mid = (low+high)/2+1;
                if(matrix[mid][0] <= target){
                    low = mid;
                }else{
                    high = mid-1;
                }
            }
            return low;
    }

    private boolean searchMatrixColumn(int[][] matrix,int target,int rowId) {
        int low = 0; int high = matrix[rowId].length-1;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(matrix[rowId][mid] == target){
                return true;
            }
            if(matrix[rowId][mid]> target){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        
        return false;
}

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        boolean searched = new SolutionAfterReadAnswer().searchMatrix(matrix, 3);
        System.out.println(searched);
    }
}

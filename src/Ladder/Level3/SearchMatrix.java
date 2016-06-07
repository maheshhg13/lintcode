package Ladder.Level3;

public class SearchMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null || matrix.length==0)
            return false;
        
        int row=matrix.length-1;
        int col=matrix[0].length-1;
        if(matrix[row][col]<target){
            return false;
        }
        while(row>=0 && col>=0){
            if(matrix[row][col]==target){
                return true;
            }
            if(matrix[row][0]>target){
                row--;
            }else{
                col--;
            }
        }
        return false;
    }
}

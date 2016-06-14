package Ladder.Level3;

public class SearchMatrix2 {
	public int searchMatrix(int[][] matrix, int target) {
        if(matrix==null || matrix.length==0)
            return 0;
        
        int row=matrix.length-1;
        int col=matrix[0].length-1;
        
        int occr = 0;
        while(row>=0){
            occr+=processRow(matrix, row, col, target);
            row--;
        }
        return occr;
    }
    
    private int processRow(int[][] matrix, int row, int col, int target){
        int counter=0;
        if(matrix[row][0]>target || (matrix[row][0]<target && matrix[row][col]<target)){
            return counter;
        }
        while(col>=0){
            if(matrix[row][col]==target)
                counter++;
            if(matrix[row][col]<target)
                break;
            col--;
        }
        return counter;
    }
}

package Ladder.Level3;

public class SearchInsertPosition {
	public int searchInsert(int[] A, int target) {
        if(A==null || A.length==0){
            return 0;
        }
        int start=0;
        int end=A.length-1;
        while(end>=start){
            int mid = (start+end)/2;
            if(A[mid]==target){
                return mid;
            }
            else if(A[mid]>target){
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return end+1;
    }

}

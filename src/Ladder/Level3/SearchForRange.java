package Ladder.Level3;

public class SearchForRange {
	public int[] searchRange(int[] A, int target) {
        if(A==null || A.length==0){
            return new int[]{-1, -1};
        }
        int start = 0;
        int end = A.length-1;
        
        while(end>=start){
            int mid = (start+end)/2;
            if(A[mid]==target){
                int s=mid;
                int e=mid;
                while(s>=0 && A[s]==target)
                    s--;
                while(e<A.length && A[e]==target)
                    e++;
                return new int[]{s+1, e-1};
                
            }else if(A[mid]>target){
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return new int[]{-1,-1};
    }

}

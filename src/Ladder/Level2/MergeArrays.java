package Ladder.Level2;

public class MergeArrays {
	public int[] mergeSortedArray(int[] A, int[] B) {
        if(A==null || A.length==0){
            return B;
        }
        if(B==null || B.length==0){
            return A;
        }
        
        int[] temp = new int[A.length+B.length];
        int ahead = 0;
        int bhead = 0;
        int thead = 0;
        while(ahead < A.length && bhead < B.length){
            if(A[ahead]<B[bhead])
            {
                temp[thead] = A[ahead];
                ahead++;
            }else{
                temp[thead] = B[bhead];
                bhead++;
            }
            thead++;
        }
        if(ahead==A.length){
            while(bhead<B.length){
                temp[thead] = B[bhead];
                bhead++;
                thead++;
            }
        }else if(bhead==B.length){
            while(ahead<A.length){
                temp[thead] = A[ahead];
                ahead++;
                thead++;
            }
        }
        return temp;
    }
}

package Ladder.Level2;

import java.util.Arrays;

public class RemoveElement {

	public int removeElement(int[] A, int elem) {
		if (A == null || (A.length == 0))
			return 0;
        //System.out.println(A.length)
		Arrays.sort(A);
		int lastPtr = A.length-1;
		int i = 0;
		while(i<=lastPtr){
			if(A[i]==elem){
				A[i]=A[lastPtr];
				lastPtr--;
			}else{
				i++;
			}
		}
		return lastPtr+1;
	}

}

package Ladder.Level2;

import java.util.Arrays;

public class RemoveElement {

	public int removeElement(int[] A, int elem) {
		if (A == null || equals(A.length == 0))
			return 0;

		Arrays.sort(A);
		int lastPtr = A.length - 1;
		for (int i = 0; i < A.length; i++) {
			if (A[i] == elem) {
				int temp = A[lastPtr];
				A[lastPtr] = A[i];
				A[i] = temp;
				temp--;
			}
		}
		return lastPtr;
	}

}

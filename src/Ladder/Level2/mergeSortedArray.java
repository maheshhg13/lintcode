package Ladder.Level2;

public class mergeSortedArray {
	public mergeSortedArray(int[] A, int m, int[] B, int n) {
		int total = m + n - 1;
		int aCtr = m - 1;
		int bCtr = n - 1;
		while (total >= 0) {
			while (aCtr >= 0 && bCtr >= 0) {
				if (A[aCtr] > B[bCtr]) {
					A[total] = A[aCtr];
					aCtr--;
				} else {
					A[total] = B[bCtr];
					bCtr--;
				}
				total--;
			}
			if (aCtr < 0) {
				while (bCtr >= 0) {
					A[total] = B[bCtr];
					total--;
					bCtr--;
				}
			} else {
				while (aCtr >= 0) {
					A[total] = A[aCtr];
					total--;
					aCtr--;
				}
			}
		}
	}
}

package lintcode;

//Given two strings, find the longest common substring.
//
//Return the length of it.
//
// Notice
//
//The characters in substring should occur continuously in original string. This is different with subsequence.
//
//Have you met this question in a real interview? Yes
//Example
//Given A = "ABCD", B = "CBCE", return 2.
//
//Challenge 
//O(n x m) time and memory.

public class LongestCommonSubstring {

	public int longestCommonSubstring(String A, String B) {
		if (A == null || A.isEmpty() || B == null || B.isEmpty())
			return 0;

		// ignore case
		A = A.toLowerCase();
		B = B.toLowerCase();
		int maxlen = 0;

		int[][] cache = new int[A.length()][B.length()];
		for (int i = 0; i < A.length(); i++) {
			for (int j = 0; j < B.length(); j++) {
				if (A.charAt(i) == B.charAt(j)) {
					if (i == 0 || j == 0) {
						cache[i][j] = 1;
					} else {
						cache[i][j] = 1 + cache[i - 1][j - 1];
					}

					if (cache[i][j] >= maxlen)
						maxlen = cache[i][j];
				}
			}
		}
		return maxlen;
	}

}

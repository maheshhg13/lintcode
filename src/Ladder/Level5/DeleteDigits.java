package Ladder.Level5;

import java.util.Arrays;

public class DeleteDigits {
	private String remove(String A, int pos) {
        return A.substring(0, pos) + A.substring(pos + 1, A.length());
    }
    
    public String DeleteDigits(String A, int k) {
        if (A.length() == k) {
            return "";
        }
        
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < A.length(); j++) {
                if (j == A.length() - 1 || A.charAt(j + 1) < A.charAt(j)) {
                    A = remove(A, j);
                    break;
                }
            }
        }
        
        int i = 0;
        while (i < A.length() - 1 && A.charAt(i) == '0') {
            i++;
        }
        return A.substring(i, A.length());
    }

}

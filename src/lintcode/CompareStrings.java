package lintcode;

//Compare two strings A and B, determine whether A contains all of the characters in B.
//
//The characters in string A and B are all Upper Case letters.
//
// Notice
//
//The characters of B in A are not necessary continuous or ordered.
//
//Have you met this question in a real interview? Yes
//Example
//For A = "ABCD", B = "ACD", return true.
//
//For A = "ABCD", B = "AABC", return false.
		
public class CompareStrings {
	
	public boolean compareStrings(String A, String B) {
		if(A.length()==0 || B.length()==0){
        	return false;
        }
    	
        int[] map = new int[26];
        A = A.toLowerCase().replace(" ", "");
        B = B.toLowerCase().replace(" ", "");
        
        for(int i=0;i<A.length();i++){
        	int posititon = A.charAt(i) - 'a';
        	map[posititon]++;
        }
        
        for(int i=0;i<B.length();i++){
        	int position = B.charAt(i) - 'a';
        	map[position]--;
        	if(map[position]<0)
        		return false;
        }
        return true;
    }

}

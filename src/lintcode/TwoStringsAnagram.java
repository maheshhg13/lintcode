package lintcode;

//Clarification
//What is Anagram?
//- Two strings are anagram if they can be the same after change the order of characters.
//
//Example
//Given s = "abcd", t = "dcab", return true.
//Given s = "ab", t = "ab", return true.
//Given s = "ab", t = "ac", return false.
//
//Challenge 
//O(n) time, O(1) extra space

public class TwoStringsAnagram {
    /**
     * @param s: The first string
     * @param b: The second string
     * @return true or false
     */
    public boolean anagram(String s, String t) {
    	
    	if(s.length()!=t.length() || s.length()==0){
        	return false;
        }
    	
        int[] map = new int[26];
        s = s.toLowerCase().replace(" ", "");
        t=t.toLowerCase().replace(" ", "");;
        for(int i=0;i<s.length();i++){
        	int posititon = s.charAt(i) - 'a';
        	map[posititon]++;
        }
        
        for(int i=0;i<t.length();i++){
        	int position = t.charAt(i) - 'a';
        	map[position]--;
        	if(map[position]<0)
        		return false;
        }
        return true;
    }
}

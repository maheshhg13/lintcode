package lintcode;

public class StrStr {
    /**
     * Returns a index to the first occurrence of target in source,
     * or -1  if target is not part of source.
     * @param source string to be scanned.
     * @param target string containing the sequence of characters to match.
     */
	public int strStr(String source, String target) {
        if(source==null || target==null)
            return -1;
        
        if(source.equals(target) || target.length()==0)
            return 0;
            
        for(int i=0;i<source.length();i++){
        	if(source.charAt(i)==target.charAt(0)){
        		if(check(source, target, i))
        			return i;
        	}
        }
        return -1;
    }
    
    private boolean check(String source, String target, int position){
    	
    	String temp = source.substring(position);
    	return temp.startsWith(target);
    }
}

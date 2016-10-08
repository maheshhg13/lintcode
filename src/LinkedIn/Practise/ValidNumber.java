package LinkedIn.Practise;

//Complexity O(n)
public class ValidNumber {
	public boolean isNumber(String s){
		if(s==null || s.length()==0){
			return false;
		}
		s = s.trim();
		boolean seenNum = false;
		boolean seenNumAfterE = true;
		boolean seenE = false;
		boolean seenP = false;
		for(int i=0;i<s.length();i++){
			char ch = s.charAt(i);
			if(ch>='0' && ch<='9'){
				seenNum = true;
				seenNumAfterE = true;
			}else if(ch=='e'){
				if(!seenNum || seenE){
					return false;
				}
				seenNumAfterE = false;
				seenE=true;
			}else if(ch=='.'){
				if(seenP || seenE){
					return false;
				}
				seenP=true;
			}else if(ch=='-' || ch=='+'){
				if(i!=0 && s.charAt(i-1)!='e' ){
					return false;
				}
			}else{
				return false;
			}
		}
		return seenNum && seenNumAfterE;
	}

}

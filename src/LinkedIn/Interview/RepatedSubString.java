package LinkedIn.Interview;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//Find all the repeating sub-string sequence of specified length in a large string sequence. The sequences returned i.e. the output must be sorted alphabetically.
//For example:
//  Input String: "ABCACBABC", repeated sub-string length: 3 
//  Output: ABC
//
//  Input String: "ABCABCA", repeated sub-string length: 2 
//  Output: AB, BC, CA

public class RepatedSubString {
	public List<String> printRepeatingStrings(String inputString, int sequenceLength){
		if(inputString==null || inputString.length()==0 || sequenceLength<0 || sequenceLength>inputString.length()){
			return null;
		}
		Set<String> subSet = new HashSet<String>();
		Set<String> recSet = new HashSet<String>();
		for(int i=0;i+sequenceLength<=inputString.length();i++){
			int j=i+sequenceLength;
			String sub = inputString.substring(i, j);
			if(subSet.contains(sub)){
				recSet.add(sub);
			}else{
				subSet.add(sub);
			}
		}
		return new ArrayList<String>(recSet);
	}
	public static void main(String[] args) {
		String inp = "ABCACBABC";
		int len = 3;
		for(String x:new RepatedSubString().printRepeatingStrings(inp, len)){
			System.out.println(x);
		}
	}

}

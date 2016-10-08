package LinkedIn.Practise;

import java.util.*;
public class MinWindowSubstring {
	//Complexity: O(n)
	public String minWindow(String s, String t){
		if(s==null || t==null || s.length()==0 || t.length()==0){
			return s;
		}
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		Map<Character, Integer> dict = new HashMap<Character, Integer>();
		for(int i=0;i<t.length();i++){
			char c = t.charAt(i);
			if(!dict.containsKey(c)){
				dict.put(c, 1);
			}else{
				dict.put(c, dict.get(c)+1);
			}
			map.put(c, 0);
		}
		
		String result="";
		int start=0;
		int count=0;
		int min = Integer.MAX_VALUE;
		for(int end=0;end<s.length();end++){
			char c = s.charAt(end);
			if(dict.containsKey(c)){
				map.put(c, map.get(c)+1);
				if(map.get(c)<=dict.get(c)){
					count++;
				}
			}
			if(count==t.length()){
				while(!dict.containsKey(s.charAt(start)) || map.get(s.charAt(start))>dict.get(s.charAt(start))){
					if(map.containsKey(s.charAt(start))){
						map.put(s.charAt(start), map.get(s.charAt(start))-1);
					}
					start++;
				}
				if(end-start+1<min){
					min = end-start+1;
					result = s.substring(start, end+1);
				}
				
			}
		}
		return result;
	}
}

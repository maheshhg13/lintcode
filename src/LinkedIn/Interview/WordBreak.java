package LinkedIn.Interview;

import java.util.*;
public class WordBreak {
	public boolean wordBreak(String s, Set<String> wordDict){
		return helper(s, wordDict, new HashSet<String>());
	}
	
	private boolean helper(String s, Set<String> dict, Set<String> visited){
		if(dict.contains(s)){
			return true;
		}else if(visited.contains(s)){
			return false;
		}
		for(String word:dict){
			if(s.startsWith(word)){
				if(helper(s.substring(word.length()),dict, visited)){
					return true;
				}
			}
		}
		visited.add(s);
		return false;
	}
}

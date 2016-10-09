package LinkedIn.Interview;
import java.util.*;
public class WordBreakII {
	public List<String> wordBreak(String s, Set<String> wordDict){
		return helper(s, wordDict, new HashMap<String, List<String>>());
	}
	private List<String> helper(String s, Set<String> dict, Map<String, List<String>> map){
		if(map.containsKey(s)){
			return map.get(s);
		}
		List<String> lst = new ArrayList<String>();
		if(s.isEmpty()){
			lst.add("");
			return lst;
		}
		for(String word:dict){
			if(s.startsWith(word)){
				List<String> sub = helper(s.substring(word.length()), dict, map);
				for(String str:sub){
					lst.add(word+(s.isEmpty()?"":" ")+str);
				}
			}
		}
		map.put(s, lst);
		return lst;
	}
}

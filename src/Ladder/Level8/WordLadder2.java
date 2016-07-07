package Ladder.Level8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class WordLadder2 {
	int min = Integer.MAX_VALUE;
    Map<Integer, List<List<String>>> map = new HashMap<Integer, List<List<String>>>();
	public List<List<String>> findLadders(String start, String end, Set<String> dict) {
		List<String> current = new ArrayList<String>();
		current.add(start);
		dict.remove(start);
		dict.add(end);
		helper(current, end, dict);
        return map.get(min);
    }
	
	private void helper(List<String> current, String end, Set<String> dict){
		String lastWord = current.get(current.size()-1);
		if(lastWord.equals(end)){
		    if(current.size()<min)
		    {
		        
		        min=current.size();
		        map.put(min, new ArrayList<List<String>>());
		        map.get(min).add(new ArrayList<String>(current));
		    }else if(current.size()==min){
		        map.get(min).add(new ArrayList<String>(current));
		    }
			return;
		}
		
		if(current.size()>=min){
		    return;
		}
		dict.removeAll(current);
		StringBuilder currentWord = new StringBuilder(lastWord);
		for(int i=0;i<lastWord.length();i++){
			char original = currentWord.charAt(i);
			for(char ch='a';ch<='z';ch++){
				if(ch==currentWord.charAt(i)){
					continue;
				}
				currentWord.setCharAt(i, ch);
				String mutated = currentWord.toString();
				
				if(dict.contains(mutated) && current.size()<min){
					current.add(mutated);
		            helper(current, end, new HashSet<String>(dict));
		            current.remove(mutated);
				}
			}
			currentWord.setCharAt(i, original);
		}
	}
}

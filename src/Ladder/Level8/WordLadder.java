package Ladder.Level8;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
	public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
		if(beginWord==null || endWord==null || beginWord.length()!=endWord.length())
			return 0;
		
		wordList.add(endWord);
		
		Queue<String> q = new LinkedList<>();
		Map<String, Integer> map = new HashMap<String, Integer>();
		q.add(beginWord);
		map.put(beginWord, 1);
		while(!q.isEmpty()){
			String current = q.poll();
			if(current.equals(endWord)){
				return map.get(current);
			}
			StringBuilder str = new StringBuilder(current);
			for(int i=0;i<current.length();i++){
				char original = current.charAt(i);
				for(char c='a';c<='z';c++){
					if(c==str.charAt(i)){
						continue;
					}
					str.setCharAt(i, c);
					String mutated = str.toString();
					if(wordList.contains(mutated) && !map.containsKey(mutated)){
						map.put(mutated, map.get(current)+1);
						q.add(mutated);
					}
				}
				str.setCharAt(i, original);
			}
		}
		return 0;
	}
}

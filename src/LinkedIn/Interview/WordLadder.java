package LinkedIn.Interview;

import java.util.*;
//Complexity O(n*k) n=Words in dictionary. k = length of longest word in dict.
public class WordLadder {
	public int ladderLength(String beginWord, String endWord, Set<String> wordList){
		Queue<String> q = new LinkedList<String>();
		q.add(beginWord);
		wordList.remove(beginWord);
		wordList.add(endWord);
		
		int level=0;
		while(!q.isEmpty()){
			int s = q.size();
			for(int i=0;i<s;++i){
				String current = q.poll();
				if(current==endWord){
					return level+1;
				}
				char[] temp = current.toCharArray();
				for(int x=0;x<temp.length;x++){
					char orig = temp[x];
					for(char c='a';c<='z';c++){
						temp[x] = c;
						String mutated = new String(temp);
						if(wordList.contains(mutated)){
							q.add(mutated);
							wordList.remove(mutated);
						}
					}
					temp[x] = orig;
				}
			}
			level++;
		}
		return 0;
	}
}

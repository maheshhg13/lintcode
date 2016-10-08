package LinkedIn.Practise;

import java.util.*;
//Complexity O(n)
public class TextJustification {
	public List<String> fullJustify(String[] words, int maxWidth){
		List<String> result = new ArrayList<String>();
		if(words==null || words.length==0 || maxWidth<0){
			return result;
		}else if(maxWidth==0){
			result.add("");
			return result;
		}
		fullJustifyMe(0, words, result, maxWidth);
		
		return result;
	}
	
	private void fullJustifyMe(int start, String[] words, List<String> result, int max){
		if(start>=words.length){
			return;
		}
		int total = 0;
		int len = 0;
		int next = -1;
		int i=start;
		for(;i<words.length && total<max;i++){
			total+=words[i].length();
			if(total>max){
				break;
			}
			len+=words[i].length();
			total++;
		}
		next = i;
		addLists(words, start, next, len, result, max);
		fullJustifyMe(next, words, result, max);
	}

	private void addLists(String[] words, int start, int next, int len, List<String> result, int max) {
		int slots = next-start-1;
		StringBuffer sb = new StringBuffer();
		if(slots==0||next==words.length){
			for(int i=start;i<next;i++){
				sb.append(words[i]);
				if(i==next-1){
					break;
				}
				sb.append(" ");
			}
			int trailing = max-len-slots;
			for(int i=0;i<trailing;i++){
				sb.append(" ");
			}
		}else{
			int equal = (max-len)/slots;
			int extra = (max-len)%slots;
			for(int i=start;i<next;i++){
				sb.append(words[i]);
				if(i==next-1){
					break;
				}
				for(int x=0;x<equal;x++){
					sb.append(" ");
				}
				if(extra>0){
					sb.append(" ");
					extra--;
				}
			}
		}
		result.add(sb.toString());
	}
}

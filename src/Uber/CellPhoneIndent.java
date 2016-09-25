package Uber;
import java.util.*;
public class CellPhoneIndent {
	public List<String> fullJustify(String[] words, int maxWidth){
		List<String> result = new ArrayList<String>();
		if(words==null || words.length==0 || maxWidth<0){
			return result;
		}
		if(maxWidth==0){
			result.add("");
			return result;
		}
		fullJustifyMe(0, words, result, maxWidth);
		return result;
	}

	private void fullJustifyMe(int start, String[] words, List<String> result, int maxWidth) {
		if(start>=words.length){
			return;
		}
		int total=0;
		int len=0;
		int next=-1;
		int i=start;
		while(i<words.length && total<maxWidth){
			total+=words[i].length();
			if(total>maxWidth){
				break;
			}
			len+=words[i].length();
			total++;
			i++;
		}
		next=i;
		addLists(words, start, next, len, result, maxWidth);
		fullJustifyMe(next, words, result, maxWidth);
	}

	private void addLists(String[] words, int start, int next, int len, List<String> result, int maxWidth) {
			StringBuffer sb = new StringBuffer();
			for(int i=start;i<next;i++){
				sb.append(words[i]);
				if(i==next-1){
					break;
				}
				sb.append(" ");
			}
		result.add(sb.toString());
	}
	public static void main(String[] args) {
		String[] words = "This is an Example of Text Justification.".split(" ");
		int maxWidth=16;
		List<String> temp = new CellPhoneIndent().fullJustify(words, maxWidth);
		for(String p:temp){
			System.out.println(p+":"+p.length());
		}
	}
}

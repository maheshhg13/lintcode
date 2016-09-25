package Uber;
import java.util.*;
public class AlienDictonary {
	boolean cycle = false;
	public String alienOrder(String[] words) {
        StringBuffer sb = new StringBuffer();
        Map<Character, List<Character>> map = new HashMap<Character, List<Character>>();
        int[] visited = new int[26];
        for(int i=0;i<words.length-1;i++){
        	for(int j=0;j<Math.min(words[i].length(), words[i+1].length());j++){
        		char first = words[i].charAt(j);
        		char second = words[i+1].charAt(j);
        		if(!map.containsKey(first)){
        			map.put(first, new ArrayList<Character>());
        		}
        		if(!map.containsKey(second)){
        			map.put(second, new ArrayList<Character>());
        		}
        		if(first!=second){
        			System.out.println(first+" comes before "+second);
        			map.get(first).add(second);
        			break;
        		}
        	}
        }

        while(!cycle && map.size()!=0){
        	dfs(map.keySet().iterator().next(), visited, sb, map);
        }
        return cycle?"":sb.toString();
    }

	private void dfs(Character next, int[] visited, StringBuffer sb,
			Map<Character, List<Character>> map) {
		if(cycle || !map.containsKey(next)){
			return;
		}
		if(visited[next-'a']==1){
			cycle=true;
			return;
		}
		visited[next-'a'] = 1;
		for(char c:map.get(next)){
			dfs(c, visited, sb, map);
		}
		sb.insert(0, next);
		visited[next-'a']=0;
		map.remove(next);
		
	}
	public static void main(String[] args) {
		String[] temp = new String[]{"za","zb","ca","cb"};
		System.out.println(new AlienDictonary().alienOrder(temp));
	}
}

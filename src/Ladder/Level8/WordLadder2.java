package Ladder.Level8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;


public class WordLadder2 {

	private boolean isOneEditDistance(String newWord, String originalWord){
	    int count=0;
	    for(int i=0;i<newWord.length();i++){
	        if(newWord.charAt(i)!=originalWord.charAt(i)){
	            count++;
	            if(count>1){
	                return false;
	            }
	        }
	    }
	    return true;
	}
	
	
	public List<List<String>> findLadders(String start, String end, Set<String> dict){
		List<List<String>> res = new ArrayList<List<String>>();
		Map<String, List<String>> nodeNeighbours = new HashMap<String, List<String>>();
		Map<String, Integer> dist = new HashMap<String, Integer>();
		bfs(start, end, dict, nodeNeighbours, dist);
		dfs(start, end, nodeNeighbours, dist, new ArrayList<String>(), res);
		return res;
	}
	public void bfs(String start, String end, Set<String> dict, Map<String, List<String>> nodeNeighbours, Map<String, Integer> dist){
		for(String str:dict){
			nodeNeighbours.put(str, new ArrayList<String>());
		}
		Queue<String> q = new LinkedList<String>();
		q.offer(start);
		dist.put(start, 0);
		
		while(!q.isEmpty()){
			int count = q.size();
			boolean foundEnd = false;
			for(int i=0;i<count;i++){
				String curr = q.poll();
				int currDist = dist.get(curr);
				List<String> neigh = new ArrayList<String>();
				neigh = getNeighbours(curr, dict);
				
				for(String n:neigh){
					
					if(!dist.containsKey(n)){
						dist.put(n, currDist+1);
						if(n.equals(end))
							foundEnd=true;
						else
							q.offer(n);
						
					}
				}
			}
			if(foundEnd)
				break;
		}
	}
	private List<String> getNeighbours(String curr, Set<String> dict) {
		List<String> ret = new ArrayList<String>();
		for(String str:dict){
			if(isOneEditDistance(str, curr)){
				ret.add(str);
			}
		}
		return ret;
	}
	
	private void dfs(String start, String end, Map<String, List<String>> nodeNeighbours, Map<String, Integer> dist, List<String> solution, List<List<String>> ret){
		solution.add(start);
		if(start.equals(end)){
			ret.add(new ArrayList<String>(solution));
		}else{
			for(String next:nodeNeighbours.get(start)){
				if(dist.get(start) == dist.get(next)-1){
					dfs(next, end, nodeNeighbours, dist, solution, ret);
				}
			}
		}
		solution.remove(solution.size() - 1);
	}
}

package Uber;

import java.util.*;

public class CombinationList {
	List<List<Integer>> result = new ArrayList<List<Integer>>();
	public List<List<Integer>> fun(List<List<Integer>> lst){
		helper(lst, new ArrayList<Integer>(), 0);
		return result;
		
	}
	
	private void helper(List<List<Integer>> lst, List<Integer> curr, int start){

		if(start==lst.size()){
			result.add(new ArrayList<Integer>(curr));
			return;
		}
		List<Integer> m = lst.get(start);
		for(int x:m){
			curr.add(x);
			helper(lst, curr, start+1);
			curr.remove(curr.size()-1);
		}
;	}
	
	public static void main(String[] args) {
		List<List<Integer>> temp = new ArrayList<List<Integer>>();
		temp.add(Arrays.asList(1,2, 3));
		temp.add(Arrays.asList(1));
		temp.add(Arrays.asList(1,2));
		List<List<Integer>> x = new CombinationList().fun(temp);
		for(List<Integer> l:x){
			System.out.println();
			for(int n:l){
				System.out.print(n+" ");
			}
		}
	}
}

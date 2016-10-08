package LinkedIn.Interview;

import java.util.*;
public class FactorCombinations {
	public List<List<Integer>> getFactors(int n){
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(n<4){
			return result;
		}
		helper(result, new ArrayList<Integer>(), 2, n);
		return result;
		
	}
	
	private void helper(List<List<Integer>> result, List<Integer> current, int start, int n){
		if(n<=1 && current.size()>1){
			result.add(new ArrayList<Integer>(current));
		}else{
			for(int i=start;i<=n;i++){
				if(n%i==0){
					current.add(i);
					helper(result, current, i, n/i);
					current.remove(current.size()-1);
				}
			}
		}
	}
	
	private void helper(int n){
		while(n>1){
			
		}
	}
}

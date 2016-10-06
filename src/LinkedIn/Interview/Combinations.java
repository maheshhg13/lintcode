package LinkedIn.Interview;

import java.util.*;
public class Combinations {
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		helper(result, n, 1, new Integer[k], 0, k);
		return result;
    }
    private void helper(List<List<Integer>> result, int n, int start, Integer[] current, int kIndex, int k){
        if(kIndex==k){
            result.add(new ArrayList<Integer>(Arrays.asList(current)));
            return;
        }
        for(int i=start;i<=n;i++){
        	current[kIndex] = i;
        	helper(result, n, i+1, current, kIndex+1, k);
        }
    }
    public static void main(String[] args) {
		List<List<Integer>> result = new Combinations().combine(4, 2);
		for(List<Integer> temp:result){
			for(Integer x:temp){
				System.out.print(x+" ");
			}
			System.out.println();
		}
	}
}

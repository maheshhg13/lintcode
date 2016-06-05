package Ladder.Level2;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	public int[] twoSum(int[] numbers, int target) {
		if(numbers==null || numbers.length==0){
        	return new int[]{-1,-1};
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0;i<numbers.length;i++){
        	int temp = target-numbers[i];
        	if(map.containsKey(temp)){
        		return new int[]{map.get(temp)+1, i+1};
        	}
        	map.put(numbers[i], i);
        	}
        return new int[]{-1,-1};
        }
    
}

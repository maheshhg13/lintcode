package Ladder.Level2;

import java.util.ArrayList;
import java.util.HashMap;

public class SumZero {
	
	public ArrayList<Integer> subarraySum(int[] nums) {
		ArrayList<Integer> toReturn = new ArrayList<Integer>();
		for(int start=0;start<nums.length;start++){
			int sum=0;
			for(int current = start;current<nums.length;current++){
				sum+=nums[current];
				if(sum==0){
					toReturn.add(start);
					toReturn.add(current);
					return toReturn;
				}
			}
		}
        return toReturn;
    }
	public static ArrayList<Integer> subarraySum2(int[] nums) {
		ArrayList<Integer> toReturn = new ArrayList<Integer>();
		int[][] matrix = new int[nums.length][nums.length];
		int sum = nums[0];
		for(int i=1;i<nums.length;i++){
			sum = sum+nums[i];
			matrix[0][i]=sum;
			if(sum==0){
				toReturn.add(0);
				toReturn.add(i);
				return toReturn;
			}
			//System.out.println(matrix[0][i]);
		}
		for(int row=1;row<nums.length;row++){
			System.out.println("---");
			for(int col=row;col<nums.length;col++){
				
				if(row==col){
					continue;
				}
				
				//System.out.print((matrix[row-1][col]-nums[row-1])+" ");
				matrix[row][col] = (matrix[row-1][col]-nums[row-1]);
				if(matrix[row][col]==0){
					toReturn.add(row);
					toReturn.add(col);
					return toReturn;
				}
			}
		}
        return toReturn;
    }
	
	private static ArrayList<Integer> subArraySumsZero(int [] seed)
	{
	    //int [] seed = new int[] {1,2,3,4,-9,6,7,-8,1,9};
		ArrayList<Integer> toReturn = new ArrayList<Integer>();
	    int currSum = 0;
	    HashMap<Integer, Integer> sumMap = new HashMap<Integer, Integer>();
	    for(int i = 0 ; i < seed.length ; i ++)
	    {
	    	
	        currSum += seed[i];
	        
	        System.out.println("HASH MAP HAS: " + sumMap);
	    	System.out.println("Curr Sum: "+currSum);
	    	System.out.println("Seed: "+seed[i]);
	    	
	        if(currSum == 0)
	        {
	        	toReturn.add(0);
	        	toReturn.add(i);
	        	return toReturn;
	            //System.out.println("subset : { 0 - " + i + " }");
	        }
	        else if(sumMap.get(currSum) != null)
	        {
//	            System.out.println("subset : { " 
//	                                + (sumMap.get(currSum) + 1) 
//	                                + " - " + i + " }");
//	            sumMap.put(currSum, i);
	            toReturn.add(sumMap.get(currSum) + 1);
	        	toReturn.add(i);
	        	return toReturn;
	            
	        }
	        sumMap.put(currSum, i);
	    }
	    System.out.println("HASH MAP HAS: " + sumMap);
	    toReturn.add(0);
    	toReturn.add(0);
    	return toReturn;
	}
	
	public static void main(String[] args) {
		System.out.println(subArraySumsZero(new int[]{-3,-3,1,2,4}));
		
	}

}

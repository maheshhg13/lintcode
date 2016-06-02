package Ladder.Level2;

//Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
//
//Do not allocate extra space for another array, you must do this in place with constant memory.
//Given input array A = [1,1,2],
//
//Your function should return length = 2, and A is now [1,2].


public class RemoveDuplicates {
	
	public int removeDuplicates(int[] nums) {
        int ptr = nums.length-1;
        int i=1;
        while(i<=ptr){
        	if(nums[i-1]==nums[i]){
        		
        	}
        }
        return ptr;
    }

}

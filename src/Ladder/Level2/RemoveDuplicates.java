package Ladder.Level2;

//Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
//
//Do not allocate extra space for another array, you must do this in place with constant memory.
//Given input array A = [1,1,2],
//
//Your function should return length = 2, and A is now [1,2].


public class RemoveDuplicates {
	
	public static int removeDuplicates(int[] nums) {
		 if(nums==null || nums.length==0)
	            return 0;
	            
	      int i=1;
	      int j=0;
	      while(i<nums.length && j<nums.length){
	          while(i<nums.length && j<nums.length && nums[j]==nums[i]){
	              i++;
	          }
	          
	          if(i<nums.length && j<nums.length){
	              j++;
	              nums[j]=nums[i];
	          }
	      }
	      return j+1;
    }
	public static void main(String[] args) {
		System.out.println(removeDuplicates(new int[]{-10,0,1,2,3}));
	}

}

package Ladder.Level3;

public class SearchRotatedSorted2 {
	public boolean search(int[] nums, int target) {
        if(nums==null ||nums.length==0){
           return false;
       }
       if(nums.length==1){
           return nums[0]==target;
       }
       
       int brk=0;
       for(int i=1;i<nums.length-1;i++){
           if(nums[0]<=nums[i] && (nums[i+1]<nums[i] || nums[i+1]>nums[i])){
               brk = i;
           }
       }
       if(nums[brk]==target){
           return true;
       }else if(nums[0]>target){
           return binarySearch(nums, brk+1, nums.length-1, target);
       }else{
           return binarySearch(nums, 0, brk-1, target);
       }
   }
   private boolean binarySearch(int[] nums, int start, int end, int target){
       while(end>=start){
         int mid=(start+end)/2;
           if(nums[mid]==target){
               return true;
           }else if(nums[mid]>target){
               end = mid-1;
           }else{
               start= mid+1;
           }   
       }
       return false;
   }

}

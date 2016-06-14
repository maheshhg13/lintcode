package Ladder.Level3;

public class MinRotatedSorted2 {
	public int findMin(int[] nums) {
        if(nums==null ||nums.length==0){
            return 0;
        }
        if(nums.length==1){
            return nums[0];
        }
        
        int brk=0;
        for(int i=1;i<nums.length-1;i++){
            if(nums[0]<=nums[i] && (nums[i+1]<nums[i] || nums[i+1]>nums[i])){
                brk = i;
            }
        }
        if(nums[brk]<nums[brk+1]){
            return nums[brk];
        }
        return nums[brk+1];
        
    }
}

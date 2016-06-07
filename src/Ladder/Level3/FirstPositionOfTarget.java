package Ladder.Level3;

public class FirstPositionOfTarget {
	public int binarySearch(int[] nums, int target) {
        if(nums==null || nums.length==0)
            return 0;
        int start = 0;
        int end = nums.length-1;
        
        while(end>=start){
            if(nums[start]<target && nums[end]<target)
             return -1;
            int mid = (start+end)/2;
            if(nums[mid]==target){
                mid = mid-1;
                while(mid>=0 && nums[mid]==target)
                    mid--;
                return mid+1;
            }
            else if(nums[mid]>target){
                int num = nums[mid];
                while(nums[mid]==num)
                    mid--;
                end=mid;
            }
            else{
                int num = nums[mid];
                while(nums[mid]==num)
                    mid++;
                start=mid;
            }
        }
        return end;
    }

}

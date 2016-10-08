package LinkedIn.Practise;

public class SearchRotatedSortedArray {
	//Complexity O(log n). Read MORE ***
	public int search(int[] nums, int target){
		if(nums==null || nums.length==0){
			return -1;
		}
		int left=0;
		int right=nums.length-1;
		while(left<=right){
			int mid = (left+right)/2;
			if(nums[mid]==target){
				return mid;
			}else if(nums[mid]>=nums[left]){
				if(target<nums[mid] && target>=nums[left]){
					left = mid+1;
				}else{
					right=mid-1;
				}
			}else{
				if(target>nums[mid] && target<=nums[left]){
					left=mid+1;
				}else{
					right=mid-1;
				}
			}
		}
		return -1;
	}
}

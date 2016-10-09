package LinkedIn.Interview;

public class findKthLargest {
	public int findKth(int[] nums, int k){
		if(nums==null || nums.length==0 || k<=0){
			return -1;
		}
		
		int min=0;
		int max=0;
		for(int x:nums){
			if(x<min){
				x=min;
			}else if(x>max){
				x=max;
			}
		}
		
		int[] arr = new int[max-min+1];
		for(int x:nums){
			arr[x-min]++;
		}
		for(int i=arr.length-1;i>=0;i--){
			k-=arr[i];
			if(k<=0){
				return i+min;
			}
		}
		return -1;
	}
}

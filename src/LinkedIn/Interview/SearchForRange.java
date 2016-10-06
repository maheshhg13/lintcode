package LinkedIn.Interview;

public class SearchForRange {
    public int[] searchRange(int[] nums, int target) {
        if(nums==null || nums.length==0){
            return new int[]{-1};
        }
        int f = searchFirst(nums, 0, nums.length-1, target);
        int l = searchLast(nums, f, nums.length-1, target);
        return new int[]{f, l};
    }
    
    private int searchFirst(int[] nums, int start, int end, int target){
        if(nums==null || nums.length==0){
            return -1;
        }
        while(start<=end){
            int mid = (start+end)/2;
            if(nums[mid]==target && (mid==0 || nums[mid-1]<target)){
                return mid;
            }else if(nums[mid]>=target){
                end = mid-1;
            }else{
                start= mid +1;
            }
        }
        return -1;
    }
    
    private int searchLast(int[] nums, int start, int end, int target){
        if(nums==null || nums.length==0){
            return -1;
        }
        while(start<=end){
            int mid = (start+end)/2;
            //System.out.println(mid);
            if(nums[mid]==target && (mid==end || nums[mid+1]>target)){
                return mid;
            }else if(nums[mid]>target){
                end= mid-1;
            }else{
                start = mid+1;
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
		int[] temp = {1,2,3,3,3,3,3,3,4,5};
		int[] ans = new SearchForRange().searchRange(temp, 3);
		for(int x:ans){
			System.out.print(x+" ");
		}
	}
}

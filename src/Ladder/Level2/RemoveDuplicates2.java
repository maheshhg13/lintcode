package Ladder.Level2;

public class RemoveDuplicates2 {
	public static int removeDuplicates(int[] nums) {
		int i = 0;
		int k=2;
		   for (int n : nums)
		      if (i < k || n > nums[i - k])
		         nums[i++] = n;
		   return i;
    }
	public static void main(String[] args) {
		System.out.println(removeDuplicates(new int[]{-8,0,1,2,3}));
	}
}

package LinkedIn.Interview;

import java.util.Arrays;

public class LongestPalindromicSubSequence {
	public int longestSubSequence(int[] arr){
		if(arr==null || arr.length==0){
			return 0;
		}
		int[][] mem = new int[arr.length][arr.length];
		for(int i=0;i<arr.length;i++){
			Arrays.fill(mem[i], -1);
			mem[i][i] = 1;
		}
		return helper(arr, 0, arr.length-1, mem);
	}
	private int helper(int[] arr, int i, int j, int[][] mem){
		if(i>j){
			return 0;
		}
		
		if(mem[i][j]==-1){
			if(arr[i]==arr[j]){
				mem[i][j] = 2 + helper(arr, i+1, j-1, mem);
			}else{
				mem[i][j] = Math.max(helper(arr, i+1, j, mem), helper(arr, i, j-1, mem));
			}
		}
		return mem[i][j];
	}
	
	public static void main(String[] args) {
		int[] arr = new int[]{1,2,4,1};
		System.out.println(new LongestPalindromicSubSequence().longestSubSequence(arr));
	}
}

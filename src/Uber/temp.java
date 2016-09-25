package Uber;

public class temp {
	int gMin = Integer.MAX_VALUE;
	int closestSequence2(int[] a, int[] b) {
	    helper(b, a, 0, 0, 0);
	    return gMin;
	}
	
	public void helper(int[] b, int[] a, int aInd, int bIndx, int min){
	    if(aInd==a.length){
	        if(min<gMin){
	        	gMin=min;
	        }
	        return;
	    }
	
	    int key = a[aInd];
	    for(int i=bIndx;i<b.length-a.length+aInd+1;i++){
	        int temp = Math.abs(key-b[i]);
	        if(min+temp>gMin){
	        	continue;
	        }
	        min+=temp;
	        helper(b, a, aInd+1, i+1, min);
	        min-=temp;
	    }
	}
	
	private int minRange(int[] arr, int i, int j, int key){
		int indx = 0;
		int min = 0;
		for(int k=i;k<j;k++){
			if(Math.abs(arr[k]-key)<min){
				min = arr[k];
				indx = k;
			}
		}
		return indx;
	}

	public String shortestPalindrome(String s) {
		int i = 0;
		int j = s.length() - 1;
		System.out.println("Got: "+s);
		while (j >= 0) {
			if (s.charAt(i) == s.charAt(j)) {
				i++;
			}
			j--;
		}
		System.out.println("After looping: i: "+i+" j:"+j);
		if (i == s.length()){
			System.out.println("i== s.length()");
			return s;
		}
			
		String suffix = s.substring(i);
		System.out.println("Suffix: "+suffix);
		String prefix = new StringBuilder(suffix).reverse().toString();
		System.out.println("Prefix: "+prefix);
		String mid = shortestPalindrome(s.substring(0, i));
		System.out.println("mid: "+mid);
		System.out.println("Returning: "+prefix+mid+suffix);
		return prefix + mid + suffix;
	}
	
	public static void main(String[] args) {
		int[] a = new int[]{-26, -35, 44, 23, 7, -40, -14, 18, 39, -12, -22, -5, 4, 10, 0, -11, 45, -16, 2, 46, -45, 2, -3, -50, -17, 49, 47, -15, 49, -15, 16, 43, 33, 22, -34, 48, -41, 12, 19, -17, 31, -46, 38, -21, 16, 3, -43, -50, 4, 7};
		int[] b = new int[]{18, 16, -22, 4, -5, -46, -43, 28, 50, -47, 31, -41, 35, -6, -20, -33, 10, 34, -7, -46, 0, 35, 29, 22, 19, -48, -4, 10, -41, 26, -33, 45, -2, 24, 4, 39, -2, -42, 41, 18, -28, 28, -44, 19, 34, 41, 33, -27, -26, 41};
		//int[] a = new int[]{1, 2, 6};
		//int[] b = new int[]{0, 1, 3, 4, 5};
		//System.out.println(new temp().closestSequence2(a, b));
		String x = "aacecaaa";
		System.out.println(new temp().shortestPalindrome(x));
	}

}

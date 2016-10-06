package LinkedIn.Interview;


public class PowersImpl {  
	private long next = 4;  
	private int base = 2;  

	/* binary search */
	public int isPerfectPower(long n) {  
		for (int b=2; b<(int)(Math.log(n)/Math.log(2)+1); ++b) {  
			long l = 2, r = n/2;  
			while (l <= r) {  
				long mid = l + (r - l) / 2;  
				long v = (long)Math.pow(mid, b);  
				if (v == n) return (int)mid;  
				if (v > n) {  
					r = mid - 1;  
				} else {  
					l = mid + 1;  
				}  
			}  
		}  
		return -1;  
	}  

	public Long next() {  
		long pre = next;  
		next = next*base;  
		for (long i=pre+1; i<next; ++i) {  
			int a = isPerfectPower(i);  
			if (a > 0) {  
				next = i;  
				break;  
			}  
		}  
		return pre;  
	}  

	public void reset() {  
		next = 4; base = 2;  
	}  
	
	public static void main(String[] args) {
		PowersImpl m = new PowersImpl();
		int n=10;
		while((n--)>=0){
			System.out.println(m.next());
		}
	}
}  

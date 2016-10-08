package LinkedIn.Interview;

public class LogNIntegral {
	public static int getIntegralPart (float n) {
	    if (n <= 0) {  // invalid input
	        return -1;
	    }
	    int result = 0;
	    int num = (int)n;
	    while ((num >>= 1) != 0) {
	        ++result;
	    }
	    return result;
	}
	public static void main(String[] args) {
		System.out.println(LogNIntegral.getIntegralPart(3.0f));
	}
}

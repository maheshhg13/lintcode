package Ladder.Level4;

public class CheckPowerOfTwo {
	public boolean checkPowerOf2(int n) {
        if(n<=0)
            return false;
        if(n==1)
            return true;
        int num = (n&(n-1));
        if(num==0)
            return true;
        return false;
    }

}

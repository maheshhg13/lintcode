package Ladder.Level4;

public class TrailingZeroes {
	public long trailingZeros(long n) {
        if(n<5){
            return 0;
        }
        long count = 0;
        for(long i=5;(n/i)>=1;i*=5){
            count+=n/i;
        }
        return count;
    }
}

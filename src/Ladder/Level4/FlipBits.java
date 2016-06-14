package Ladder.Level4;

public class FlipBits {
	public static int bitSwapRequired(int a, int b) {
		int count = 0;
        int number = 32;
        
		if(a==b){
            return 0;
		}
        int xor = a^b;
        
        while(number>0){
            count+=xor&1;
            xor = xor >> 1;
            number--;
        }
        return count;
    }
}

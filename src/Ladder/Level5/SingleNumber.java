package Ladder.Level5;

public class SingleNumber {
	public int singleNumber(int[] A) {
        int temp=0;
        for(int x:A){
            temp=temp^x;
        }
        return temp;
    }
}

package Ladder.Level5;

public class JumpGame {
	public boolean canJump(int[] A) {
        return jump(A, 0, A[0]);
    }
    private boolean jump(int[] A, int loc, int leap){
        if((loc+leap)>=A.length-1){
            return true;
        }
        if(leap==0 || loc>A.length-1){
            return false;
        }
        
        boolean res = false;
        for(int i=1;i<=leap;i++){
            int newLoc = loc+i;
            res = (res || jump(A, newLoc, A[newLoc])); 
        }
        return res;
        
    }
}

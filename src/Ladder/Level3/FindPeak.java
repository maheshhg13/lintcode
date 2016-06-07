package Ladder.Level3;

public class FindPeak {
	public int findPeak(int[] num) {
        if(num==null || num.length==0)
	        return 0;
	        
	        //int brk = 0;
	        for(int i=1;i<num.length-1;i++){
	            if(num[i-1]<num[i] && num[i+1]<num[i]){
	                return i;
	            }
	            
	        }
	        return -1;
    }

}

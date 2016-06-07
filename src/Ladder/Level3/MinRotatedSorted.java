package Ladder.Level3;

public class MinRotatedSorted {
	public int findMin(int[] num) {
	       if(num==null || num.length==0)
	        return 0;
	        
	        int brk = 0;
	        for(int i=1;i<num.length-1;i++){
	            if(num[i-1]<num[i] && num[i+1]<num[i]){
	                brk=i;
	            }
	            
	        }
	        if(num[0] > num[brk+1]){
	                return num[brk+1];
	            }
	            return num[0];
	    }

}

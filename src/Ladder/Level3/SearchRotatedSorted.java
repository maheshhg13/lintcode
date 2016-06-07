package Ladder.Level3;

public class SearchRotatedSorted {
	public int search(int[] num, int target) {
        if(num==null || num.length==0)
	        return -1;
	        
	        int brk = -1;
	        for(int i=1;i<num.length-1;i++){
	            if(num[i-1]<num[i] && num[i+1]<num[i]){
	                brk=i;
	            }
	            
	        }
	        
	        
	        
	            
	        int start = 0;
	        int end = num.length-1;
	        if(brk!=-1){
	            
	            if(num[0]<target && num[brk]<target){
	            return -1;
	        }
	            
	        if(num[0]>target){
	            start = brk;
	        }else{
	            end = brk;
	        }
	        }
	        
	        while(end>=start){
	            if(num[start]==target)
	                return start;
	           if(num[end]==target)
	            return end;
            int mid = (start+end)/2;
            if(num[mid]==target){
                return mid;
            }
            else if(num[mid]>target){
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        
        if(num[end+1]==target)
            return end+1;
        return -1;
	        
    }

}

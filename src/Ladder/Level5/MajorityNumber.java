package Ladder.Level5;

import java.util.ArrayList;

public class MajorityNumber {
	public int majorityNumber(ArrayList<Integer> nums) {
	       int num=0;
	       int count =0 ;
	       for(int x:nums){
	           if(count==0){
	               num=x;
	               count = 1;
	           }else if(num==x){
	             count++;  
	           }else{
	               count--;
	           }
	               
	       }
	       return num;
	    }
}

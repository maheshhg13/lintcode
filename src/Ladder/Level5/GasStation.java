package Ladder.Level5;

public class GasStation {
	public int canCompleteCircuit(int[] gas, int[] cost) {
	       if(gas==null||cost==null||gas.length!=cost.length){
	           return -1;
	       }
	       int total=0;
	       int remain = 0;
	       int start = 0;
	       for(int i=0;i<gas.length;i++){
	           remain += gas[i]-cost[i];
	           if(remain<0){
	               remain=0;
	               start=i+1;
	           }
	           total+=gas[i]-cost[i];
	       }
	       if(total<0)
	        return -1;
	        
	        return start;
	       
	    }
	    //[-1, -1, 2, 1]
}

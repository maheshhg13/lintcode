package Ladder.Level2;

import java.util.Arrays;

public class ThreeSumClosest {
	public int threeSumClosest(int[] numbers, int target) {
        //ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
        if(numbers.length<3){
            return target;
        }
        int diff = Integer.MAX_VALUE;
        int t = 0;
        Arrays.sort(numbers);
        for(int one=0; one<numbers.length;one++){
            for(int two=one+1;two<numbers.length;two++){
                int sum = numbers[one]+numbers[two];
                int three=two+1;
                while(three<numbers.length){
                    if(numbers[three]+sum==target){
                        return target;
                    }else{
                        int d = Math.abs((numbers[three]+sum)-target);
                        if(d<diff){
                            diff=d;
                            t=numbers[three]+sum;
                        }
                    }
                    three++;
                }
            }
        }
        return t;
    }

}

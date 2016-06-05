package Ladder.Level2;

import java.util.ArrayList;
import java.util.Arrays;

public class ThreeSum {
	public ArrayList<ArrayList<Integer>> threeSum(int[] numbers) {
        // write your code here
        //-4 -1 -1 0 1 2
        ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
        if(numbers.length<3){
            return arr;
        }
        Arrays.sort(numbers);
        for(int one=0; one<numbers.length;one++){
            for(int two=one+1;two<numbers.length;two++){
                int sum = numbers[one]+numbers[two];
                int three=two+1;
                while(three<numbers.length){
                    if(numbers[three]+sum==0){
                        ArrayList<Integer> temp = new ArrayList<Integer>();
                        temp.add(numbers[one]);
                        temp.add(numbers[two]);
                        temp.add(numbers[three]);
                        if(!arr.contains(temp))
                            arr.add(temp);
                    }
                    three++;
                }
            }
        }
        return arr;
    }

}

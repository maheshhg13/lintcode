package LinkedIn.Interview;

import java.util.*;
public class ClimbingStairs {
	public int climbStairs(int n) {
        int[] map = new int[n+1];
        for(int i=0;i<=n;i++){
            if(i<=1){
                map[i] = 1;
                continue;
            }
            map[i] = map[i-1]+map[i-2];
        }
        return map[n];
    }

}

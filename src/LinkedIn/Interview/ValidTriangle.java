package LinkedIn.Interview;

import java.util.Arrays;

public class ValidTriangle {
	public boolean existTriangle(int[] edges) {
		if(edges==null || edges.length==0){
			return false;
		}
		
		Arrays.sort(edges);	
		for(int i=0;i<=edges.length-3;i++){
			if(i!=0 && edges[i]==edges[i-1]){
				continue;
			}
			for(int j=i+1;j<=edges.length-2;j++){
				if(j!=i+1 && edges[j]==edges[i-1]){
					continue;
				}
				int sum = edges[i]+edges[j];
				if(sum>edges[j+1]){
					return true;
				}
			}
		}
		return true;
	}

}

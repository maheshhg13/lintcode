package LinkedIn.Practise;
import java.util.*;

class Point{
	int x;
	int y;
	public Point() { x = 0; y = 0; }
	public Point(int a, int b) { x = a; y = b; }
}
//Complexity: O(n*n)
public class maxPointsOnLine {
	public static int maxPoints(Point[] points){
		if(points==null || points.length==0){
			return 0;
		}
		Map<Double, Integer> map = new HashMap<Double, Integer>();
		int max = 1;
		for(int i=0;i<points.length;i++){
			map.clear();
			int dup=0;
			for(int j=i+1;j<points.length;j++){
				if(points[i].x ==points[j].x && points[i].y==points[j].y){
					dup++;
					continue;
				}
				double slope = points[j].x==points[i].x?Integer.MAX_VALUE:0.0+(points[j].y-points[i].y)/(points[j].x-points[i].x);
				if(map.containsKey(slope)){
					map.put(slope, map.get(slope)+1);
				}else{
					map.put(slope, 2);
				}
				
			}
			for(int x:map.values()){
				if(max<dup+x){
					max = dup+x;
				}
			}
			
		}
		return max;
	}
}

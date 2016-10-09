package LinkedIn.Interview;

import java.util.*;
public class KNearestPoints {
	
	public List<Point> findKNearestPoints(List<Point> points, Point original, int k){		
		Queue<Point> q = new PriorityQueue<Point>(k, new Comparator<Point>(){
			@Override
			public int compare(Point a, Point b){
				return Double.compare(b.getDistance(original), a.getDistance(original));
			}
		});
		for(Point x:points){
			if(q.size()<k){
				q.add(x);
			}else{
				
				if(x.getDistance(original)<q.peek().getDistance(original)){
					q.poll();
					q.add(x);
				}
			}
		}
		
		return new ArrayList<Point>(q);
	}
	
	class Point{
        int x, y;
        public Point (int x, int y) {
            this.x= x;
            this.y = y;
        }
        public double getDistance(Point original){
        	return Math.hypot(x - original.x, y - original.y);
        }
    }

}

package LinkedIn.Practise;
import java.util.*;

class Interval {
	int start;
	int end;
	Interval() { start = 0; end = 0; }
	Interval(int s, int e) { start = s; end = e; }
}
//Complexity: O(n); Space: O(n)
public class InsertInterval {
	public List<Interval> insert(List<Interval> intervals, Interval newInterval){
		if(intervals==null || intervals.size()==0 || newInterval==null){
			return null;
		}
		List<Interval> result = new ArrayList<Interval>();
		for(Interval current:intervals){
			if(current.end<newInterval.start){
				result.add(current);
			}else if(current.start>newInterval.end){
				result.add(newInterval);
				newInterval = current;
			}else{
				newInterval = new Interval(Math.min(newInterval.start, current.start), Math.max(newInterval.end, current.end));
			}
		}
		return result;
	}

}

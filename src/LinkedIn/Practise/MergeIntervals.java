package LinkedIn.Practise;

import java.util.*;
public class MergeIntervals {
	public List<Interval> merge(List<Interval> intervals){
		if(intervals==null || intervals.size()==0){
			return intervals;
		}
		List<Interval> result = new ArrayList<Interval>();
		Collections.sort(intervals, new Comparator<Interval>(){
			@Override
			public int compare(Interval a, Interval b){
				return Integer.compare(a.start, b.start);
			}
		});
		Interval first = intervals.get(0);
		for(int i=1;i<intervals.size();i++){
			Interval second = intervals.get(i);
			if(second.end<first.start){
				result.add(second);
			}else if(second.start>first.end){
				result.add(first);
				first=second;
			}else{
				first = new Interval(Math.min(first.start, second.start), Math.max(first.end, second.end));
			}
		}
		result.add(first);
		return result;
	}
}

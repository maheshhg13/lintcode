package LinkedIn.Interview;

import java.util.*;
public class MedianFinder {
	private PriorityQueue<Integer> minHeap;
	private PriorityQueue<Integer> maxHeap;
	private int count;
	public MedianFinder(){
		count=0;
		minHeap = new PriorityQueue<Integer>();
		maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
	}
	public void addNum(int num){
		if(count%2==0){
			maxHeap.offer(num);
			minHeap.offer(maxHeap.poll());
		}else{
			minHeap.add(num);
			maxHeap.add(minHeap.poll());
		}
		count++;
	}

	public double findMedian(){
		if(count%2==0){
			return (minHeap.peek()+maxHeap.peek())/2;
		}
		return minHeap.peek();
	}
}

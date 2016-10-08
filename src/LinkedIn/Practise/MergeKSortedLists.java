package LinkedIn.Practise;

import java.util.*;

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}
 
//Complexity:O(n.log(k)). Because we are iterating over all the items. and for each iteration
//we are spending O(k) time in inserting into PriorityQueue. Space: O(k)
public class MergeKSortedLists {
	public ListNode mergeKLists(ListNode[] lists){
		if(lists==null || lists.length==0){
			return null;
		}
		ListNode result = new ListNode(-1);
		ListNode head = result;
		PriorityQueue<ListNode> q = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>(){
				@Override
				public int compare(ListNode a, ListNode b){
					return Integer.compare(a.val, b.val);
				}
		});
		while(!q.isEmpty()){
			ListNode item = q.poll();
			result.next=item;
			result = result.next;
			if(item.next!=null){
				q.offer(item.next);
			}
		}
		return head.next;
	}
}

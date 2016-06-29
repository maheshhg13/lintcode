package Ladder.Level6;

public class ReverseLinkedList {
	public ListNode reverse(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode dummyHead = head;
        ListNode prev = head;
        ListNode tracker = head.next;
        while(tracker.next!=null){
            ListNode temp = tracker.next;
            tracker.next = prev;
            prev = tracker;
            tracker = temp;
        }
        tracker.next = prev;
        dummyHead.next = null;
        return tracker;
        
    }
}

package Ladder.Level6;

public class ReorderList {
	public void reorderList(ListNode head) {  
        if(head==null || head.next==null){
            return;
        }

        while(head!=null){
            ListNode tracker = head.next;
            ListNode m = head;
            while(tracker!=null && tracker.next!=null){
                tracker = tracker.next;
                m = m.next;
            }
            if(m==head){
                return;
            }
            ListNode dummyHead = head.next;
            tracker.next = head.next;
            head.next = tracker;
            m.next=null;
            head=dummyHead;
        }
    }
}

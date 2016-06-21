package Ladder.Level6;

public class ReorderList {
	public void reorderList(ListNode head) {  
        if(head==null || head.next==null){
            return;
        }
        ListNode dummyHead = head;
        while(dummyHead!=null){
            ListNode tracker = dummyHead.next;
            ListNode m = dummyHead;
            while(tracker!=null && tracker.next!=null){
                tracker = tracker.next;
                m = m.next;
            }
            if(m==dummyHead){
                return;
            }
            dummyHead = dummyHead.next;
            tracker.next = head.next;
            head.next = tracker;
            m.next=null;
            head=dummyHead;
        }
    }
}

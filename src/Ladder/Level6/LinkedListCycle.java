package Ladder.Level6;

public class LinkedListCycle {
	public boolean hasCycle(ListNode head) {  
        if(head==null || head.next==null){
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(slow!=null && fast!=null){
            slow=slow.next;
            fast = fast.next;
            if(fast!=null){
                fast=fast.next;
            }
            if(slow==fast){
                return true;
            }
        }
        return false;
    }
}

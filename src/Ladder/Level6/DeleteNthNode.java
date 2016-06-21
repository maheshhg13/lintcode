package Ladder.Level6;

public class DeleteNthNode {
	ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null || head.next==null||n==0){
            return null;
        }
        
        ListNode dummy = head;
        ListNode target = head;
        while(n>0){
            dummy = dummy.next;
            n--;
        }
        if(dummy==null){
            return head.next;
        }
        
        while(dummy.next!=null){
            target = target.next;
            dummy = dummy.next;
        }
        target.next = (target.next).next;
        return head;
    }
}

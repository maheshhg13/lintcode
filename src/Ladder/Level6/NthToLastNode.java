package Ladder.Level6;

public class NthToLastNode {
	ListNode nthToLast(ListNode head, int n) {
        if(head==null){
            return null;
        }
        ListNode target = head;
        while(n>0){
            target = target.next;
            n--;
        }
        while(target!=null){
            head = head.next;
            target = target.next;
        }
        return head;
    }

}

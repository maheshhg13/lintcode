package Ladder.Level6;

public class PartitionList {
	public ListNode partition(ListNode head, int x) {
        if(head==null){
            return null;
        }
        ListNode less = new ListNode(-1);
        ListNode lessD = less;
        ListNode more = new ListNode(-1);
        ListNode moreD = more;
        while(head!=null){
            if(head.val<x){
                less.next = head;
                less = less.next;
            }else{
                more.next = head;
                more = more.next;
            }
            head = head.next;
        }
        less.next = moreD.next;
        more.next = null;
        return lessD.next;
    }

}

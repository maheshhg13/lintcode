package Ladder.Level6;

public class RemoveDuplicatesFromSortedList {
	public static ListNode deleteDuplicates(ListNode head) { 
        if(head==null){
            return null;
        }
        int lastNum = head.val;
        ListNode head2 = new ListNode(-1);
        head2.next=head;
        head=head.next;
        ListNode temp = head2.next;
        while(head!=null){
            if(head.val!=lastNum){
                lastNum = head.val;
                temp.next = head;
                temp = temp.next;
            }
            head = head.next;
        }
        temp.next = null;
        return head2.next;
    } 
}

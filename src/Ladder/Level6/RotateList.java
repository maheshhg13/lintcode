package Ladder.Level6;

public class RotateList {
	public ListNode rotateRight(ListNode head, int k) {
        if(head==null || k==0|| head.next==null){
            return head;
        }

        ListNode target = head;
        ListNode start = head;
        while(k>0){
            target=target.next;
            if(target==null){
                target=head;
            }
            k--;
        }

        while(target.next!=null){
            start=start.next;
            target = target.next;
        }

        target.next = head;
        ListNode ret = start.next;
        start.next = null;
        return ret;
        
    }
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(2);
		head.next.next.next.next = new ListNode(1);
		ListNode temp = new RotateList().rotateRight(head, 1);
		while(temp!=null){
			System.out.println(temp.val);
			temp=temp.next;
		}
	}

}

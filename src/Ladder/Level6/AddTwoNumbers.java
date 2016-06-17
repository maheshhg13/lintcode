package Ladder.Level6;

class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) {
	          val = x;
	          next = null;      
	      }
	  }

public class AddTwoNumbers {
	public ListNode addLists(ListNode l1, ListNode l2) {
        int carry  = 0;
        ListNode ret = new ListNode(-1);
        ListNode temp = ret;
        
        while(l1!=null || l2!=null){
            if(l1!=null){
                carry += l1.val;
                l1 = l1.next;
            }
            if(l2!=null){
                carry += l2.val;
                l2 = l2.next;
            }
            temp.next = new ListNode(carry%10);
            carry = carry/10;
            temp = temp.next;
        }
        if(carry>0){
            temp.next = new ListNode(carry);
        }
        return ret.next;
    }
}

package Ladder.Level6;

public class MergeTwoSortedLists {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }
        
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                dummy.next=l1;
                //System.out.println((dummy.next).val);
                l1=l1.next;
            }else{
                dummy.next = l2;
                //System.out.println((dummy.next).val);
                l2=l2.next;
            }
            dummy = dummy.next;
        }
        if(l1==null){
            while(l2!=null)
            {
                dummy.next = l2;
                //System.out.println((dummy.next).val);
                l2=l2.next;
                dummy=dummy.next;
            }
        }else if(l2==null){
          while(l1!=null)
            {
                dummy.next = l1;
                //System.out.println((dummy.next).val);
                l1=l1.next;
                dummy=dummy.next;
            }  
        }
        return head.next;
    }
}

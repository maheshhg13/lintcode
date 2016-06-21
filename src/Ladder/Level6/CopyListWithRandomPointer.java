package Ladder.Level6;

class RandomListNode {
     int label;
     RandomListNode next, random;
     RandomListNode(int x) { this.label = x; }
};

public class CopyListWithRandomPointer {
	public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode h = new RandomListNode(-1);
        RandomListNode dummy = h;
        while(head!=null){
            RandomListNode temp = new RandomListNode(head.label);
            temp.random = head.random;
            h.next = temp;
            h=h.next;
            head = head.next;
        }
        return dummy.next;
    }

}

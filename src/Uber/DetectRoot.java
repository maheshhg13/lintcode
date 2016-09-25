package Uber;

import java.util.*;

class Node{
	char val;
	Node left, right;
	public Node(char v){
		val = v;
		right = null;
		left = null;
	}
}

public class DetectRoot {
	public Node detectParent(List<Node> lst){
		Map<Node, List<Node>> map = new HashMap<Node, List<Node>>();
		for(Node x:lst){
			if(!map.containsKey(x)){
				map.put(x, new ArrayList<Node>());
			}
			map.get(x).add(x.left);
			map.get(x).add(x.right);
		}
		for(Node x:lst){
			doWork(x, map);
			if(map.size()==1){
				System.out.println("Breaking...");
				break;
			}
			System.out.println("Doing again...");
		}
		return map.keySet().iterator().next();
	}
	private void doWork(Node x, Map<Node, List<Node>> map){
		if(x==null){
			return;
		}
		for(Node c:map.get(x)){
			if(map.containsKey(c)){
				doWork(c, map);
				map.remove(c);
			}
		}
	}
	public static void main(String[] args) {
		Node e = new Node('e');
		Node f = new Node('f');
		Node b = new Node('b');
		b.left = e;
		Node c = new Node('c');
		c.right=f;
		Node a = new Node('a');
		a.left= b;
		a.right=c;
		List<Node> temp = Arrays.asList(a, b, c, e, f);
		System.out.println(new DetectRoot().detectParent(temp).val);
	}
}

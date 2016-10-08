package LinkedIn.Interview;

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }

public class TreeUpsideDown {
	public TreeNode upsideDownBinaryTree(TreeNode root){
		if(root==null){
			return root;
		}
		return helper(root, null);
	}
	
	private TreeNode helper(TreeNode root, TreeNode parent){
		if(root == null){
			return parent;
		}
		TreeNode newNode = helper(root.left, root);
		root.left = parent==null?null:parent.right;
		root.right = parent;
		return newNode;
	}
	
	private TreeNode helper2(TreeNode root){
		if(root==null){
			return root;
		}
		
		TreeNode current = root;
		TreeNode next = null;
		TreeNode temp = null;
		TreeNode prev = null;
		
		while(current!=null){
			next = current.left;
			
			current.left = temp;
			temp = current.right;
			current.right = prev;
			
			prev = current;
			current = next;
		}
		return prev;
	}

}

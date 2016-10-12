package LinkedIn.Interview;

public class DeleteBSTNode {
	public TreeNode delete(TreeNode root, int key){
		if(root==null){
			return root;
		}
		if(key<root.val){
			root.left=delete(root.left, key);
		}else if(key>root.val){
			root.right=delete(root.right, key);
		}else{
			if(root.left==null){
				return root.right;
			}else if(root.right==null){
				return root.left;
			}else{
				int min = min(root.right);
				root.val = min;
				root.right = delete(root.right, min);
			}
		}
		return root;
	}

	private int min(TreeNode right) {
		int key = right.val;
		while(right.left!=null){
			key = right.left.val;
			right = right.left;
		}
		return key;
	}

}

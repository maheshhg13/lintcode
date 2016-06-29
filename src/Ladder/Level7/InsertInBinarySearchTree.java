package Ladder.Level7;

public class InsertInBinarySearchTree {
	public TreeNode insertNode(TreeNode root, TreeNode node) {
        if (node == null || root == null) {
            return node;
        }        
        TreeNode dummy = root;
        while (root != null) {
            if (node.val < root.val) {
                if (root.left == null) {
                    root.left = node;
                    break;
                }
                root = root.left;
            } else if (node.val > root.val) {
                if (root.right == null) {
                    root.right = node;
                    break;
                }
                root = root.right;
            }
        }
        return dummy;
    }
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(2);
		root.right = new TreeNode(1);
		TreeNode node = new TreeNode(3);
		TreeNode head = new InsertInBinarySearchTree().insertNode(root, node);
		System.out.println(head.val);
		System.out.println(head.right.val);
		System.out.println(head.left.val);

	}
}

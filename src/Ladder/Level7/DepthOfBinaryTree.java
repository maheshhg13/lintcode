package Ladder.Level7;


class TreeNode {
     public int val;
      public TreeNode left, right;
      public TreeNode(int val) {
          this.val = val;
          this.left = this.right = null;
      }
  }


public class DepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }else if(root.left==null && root.right==null){
            return 1;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right)+1;
    }
}

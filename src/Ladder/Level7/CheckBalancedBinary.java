package Ladder.Level7;

public class CheckBalancedBinary {
	public boolean isBalanced(TreeNode root) {
        if(root==null){
            return true;
        }
        return helper(root)>0;
    }
    private int helper(TreeNode root){
        if(root==null){
            return 0;
        }
        int left = helper(root.left);
        int right = helper(root.right);
        
        if(left < 0 || right < 0 || Math.abs(left-right)>1){
            return Integer.MIN_VALUE;
        }
        return Math.max(right, left)+1;
    }
}

package Ladder.Level7;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;

public class ValidBST {
	public boolean isValidBST(TreeNode root) {
        return helper(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
    }
    
    public boolean helper(TreeNode root, double min, double max){
        if(root==null){
            return true;
        }
        
        if(root.val>=max || root.val<=min){
            return false;
        }
        
        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }
	public static void main(String[] args) throws UnsupportedEncodingException {
//		TreeNode root = new TreeNode(2);
//		root.right = new TreeNode(1);
//		System.out.println(new ValidBST().isValidBST(root));
		String x = "1%2C2";
		System.out.println(java.net.URLDecoder.decode(x, StandardCharsets.UTF_8.toString()));
	}
}

class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root == null)
            return true;
 
        LinkedList<BNode> queue = new LinkedList<BNode>();
        queue.add(new BNode(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY));
        while(!queue.isEmpty()){
            BNode b = queue.poll();
            if(b.n.val <= b.left || b.n.val >=b.right){
                return false;
            }
            if(b.n.left!=null){
                queue.offer(new BNode(b.n.left, b.left, b.n.val));
            }
            if(b.n.right!=null){
                queue.offer(new BNode(b.n.right, b.n.val, b.right));
            }
        }
        return true;
    }
}
//define a BNode class with TreeNode and it's boundaries
class BNode{
    TreeNode n;
    double left;
    double right;
    public BNode(TreeNode n, double left, double right){
        this.n = n;
        this.left = left;
        this.right = right;
    }
}
package Ladder.Level7;

import java.util.ArrayList;
import java.util.Stack;

public class PreOrderTraversal {
	public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        if(root==null)
            return ret;
            
        Stack<TreeNode> stk = new Stack<TreeNode>();
        stk.push(root);
        while(!stk.empty()){
            TreeNode ob = stk.pop();
            ret.add(ob.val);
            if(ob.right!=null){
                stk.push(ob.right);
            }
            if(ob.left!=null){
                stk.push(ob.left);
            }
        }
        return ret;
    }
}

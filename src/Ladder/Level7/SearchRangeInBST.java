package Ladder.Level7;

import java.util.ArrayList;
import java.util.Collections;

public class SearchRangeInBST {
	ArrayList<Integer> myList = new ArrayList<Integer>();
    public ArrayList<Integer> searchRange(TreeNode root, int k1, int k2) {
        helper(root, k1, k2);
        Collections.sort(myList);
        return myList;
    }
    private void helper(TreeNode root, int k1, int k2){
        if(root==null){
            return;
        }
        if(root.val>=k1 && root.val<=k2){
            myList.add(root.val);
        }
        helper(root.right, k1, k2);
        helper(root.left, k1, k2);
        
    }
}

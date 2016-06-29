package Ladder.Level7;

public class TreeFromPreAndInorder {
	static int preIndx = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, inorder, 0, preorder.length-1);
    }
    private TreeNode helper(int[] preorder, int[] inorder, int start, int end){
        if(start > end){
            return null;
        }
        
        TreeNode node = new TreeNode(preorder[preIndx++]);
        if(start==end){
            return node;
        }
        
        int inIndex = search(inorder, start, end, node.val);
        node.left = helper(preorder, inorder, start, inIndex-1);
        node.right = helper(preorder, inorder, inIndex+1, end);
        
        return node;
    }
    private int search(int[] arr, int start, int end, int elem){
        for(int i=start;i<=end;i++){
            if(arr[i]==elem){
                return i;
            }
        }
        return -1;
    }
}

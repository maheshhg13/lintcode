package Ladder.Level7;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class BinaryTreeSerialization {
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialHelper(root, sb);
        return sb.toString();
    }
    private void serialHelper(TreeNode root, StringBuilder str){
        if(root==null){
            str.append("#,");
            return;
        }
        str.append(root.val+",");
        serialHelper(root.left, str);
        serialHelper(root.right, str);
    }
    
    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in 
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
        Deque<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(data.split(",")));
        return buildTree(nodes);
    }
 
    private TreeNode buildTree(Deque<String> nodes) {
        String val = nodes.remove();
        if (val.equals("#")) return null;
        TreeNode node = new TreeNode(Integer.valueOf(val));
        node.left = buildTree(nodes);
        node.right = buildTree(nodes);
        return node;
    }
}

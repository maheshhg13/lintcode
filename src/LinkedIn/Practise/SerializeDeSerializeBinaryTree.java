package LinkedIn.Practise;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
//Complexity O(n)
public class SerializeDeSerializeBinaryTree {
	public String serialize(TreeNode root){
		if(root==null){
			return "#";
		}
		return root.val+" "+serialize(root.left)+" "+serialize(root.right);
	}
	int pos;
	public TreeNode deserialize(String data){
		if(data==null || data.length()==0){
			return null;
		}
		String[] splits = data.split(" ");
		pos = -1;
		return deserialize(splits);
	}
	
	private TreeNode deserialize(String[] data){
		pos++;
		if(pos>=data.length || data[pos]=="#"){
			return null;
		}
		TreeNode root = new TreeNode(Integer.parseInt(data[pos]));
		root.left = deserialize(data);
		root.right = deserialize(data);
		return root;
	} 
}

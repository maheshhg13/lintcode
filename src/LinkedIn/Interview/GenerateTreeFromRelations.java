package LinkedIn.Interview;
import java.util.*;
public class GenerateTreeFromRelations {
	public static class Relation {
		public Integer parent, child;
		public boolean isLeft;

		public Relation(Integer parent, Integer child, boolean isLeft) {
			this.parent = parent;
			this.child = child;
			this.isLeft = isLeft;
		}
	}

	public static class Node {
		public Integer val;
		public Node left, right;

		public Node(Integer val, Node left, Node right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
	
	public static Node buildTree(List<Relation> relations){
		Map<Integer, Node> map = new HashMap<Integer, Node>();
		Node root  = null;
		for(Relation r:relations){
			if(r.parent==null){
				root = getNode(r.child, map);
			}else{
				Node parent = getNode(r.parent, map);
				Node child = getNode(r.child, map);
				if(r.isLeft){
					parent.left=child;
				}else{
					parent.right=child;
				}
			}
		}
		return root;
	}
	
	private static Node getNode(Integer id, Map<Integer, Node> map){
		if(map.containsKey(id)){
			return map.get(id);
		}else{
			Node child = new Node(id, null, null);
			map.put(id, child);
			return child;
		}
	}
	
	private static ArrayList<Relation> generateRelation(String relationsString) {
		ArrayList<Relation> relations = new ArrayList<Relation>();

		if (relationsString == null || relationsString.length() == 0)
			return relations;

		for (String relationString : relationsString.split(":")) {
			String[] tempSplit = relationString.split(",");
			Relation relation = new Relation(tempSplit[1].equals("null") ? null : new Integer(tempSplit[1]), new Integer(tempSplit[0]), Boolean.parseBoolean(tempSplit[2]));
			relations.add(relation);
		}

		return relations;
	}
	
	private static ArrayList<Integer> nodeList;

	private static String convertTree(Node root) {
		nodeList = new ArrayList<Integer>();
		convertTreeHelper(root);
		return nodeList.toString();
	}

	private static void convertTreeHelper(Node node) {
		if (node == null)
			return;
		convertTreeHelper(node.left);
		nodeList.add(node.val);
		convertTreeHelper(node.right);
	}
	
	public static boolean test1() {
		ArrayList<Relation> relations = generateRelation("15,20,true:19,80,true:17,20,false:16,80,false:80,50,false:50,null,false:20,50,true");
		Node root = GenerateTreeFromRelations.buildTree(relations);
		return convertTree(root).equals("[15, 20, 17, 50, 19, 80, 16]");
	}
	public static void main(String[] args) {
		System.out.println(GenerateTreeFromRelations.test1());
	}
}

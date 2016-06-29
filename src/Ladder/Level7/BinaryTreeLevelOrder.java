package Ladder.Level7;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class BinaryTreeLevelOrder {
	static Map<Integer, ArrayList<Integer>> map = new TreeMap<Integer, ArrayList<Integer>>();
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        helper(root, 0);
        //ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        //ret.addAll();
        return new ArrayList<ArrayList<Integer>>(map.values());
    }
    private void helper(TreeNode root, int level){
        if(root==null){
            return;
        }
        addToMap(root.val, level++);
        helper(root.left, level);
        helper(root.right, level);
    }
    private void addToMap(int item, int level){
        if(!map.containsKey(level)){
            map.put(level, new ArrayList<Integer>());
        }
        map.get(level).add(item);
    }
}

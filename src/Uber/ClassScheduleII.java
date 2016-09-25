package Uber;
import java.util.*;
public class ClassScheduleII {
	boolean notPossible = false;
    public int[] findOrder(int num, int[][] pre) {
        if(pre==null || num<=0 ){
            return new int[]{0};
        }

        Map<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();
        int[] visited = new int[num];
        for(int i=0;i<num;i++){
            graph.put(i, new ArrayList<Integer>());
            visited[i] = 0;
        }
        for(int i=0;i<pre.length;i++){
            int temp[] = pre[i];
            graph.get(temp[0]).add(temp[1]);
        }
        Queue<Integer> q = new LinkedList<Integer>();
        for(int i=0;i<num;i++){
        	helper(i, graph, q, visited);
        	if(notPossible){
                return new int[]{};
        	}

        }
        int[] result = new int[q.size()];
        int i=0;
        while(!q.isEmpty()){
        	result[i++]=q.poll();
        }
        return result;
    }

	private void helper(int i, Map<Integer, List<Integer>> graph, Queue<Integer> q, int[] visited) {
	    if(visited[i]==2 || notPossible){
	        return;
	    }
	    if(visited[i]==1){
	        notPossible = true;
	        return;
	    }
		visited[i] = 1;
		for(int x:graph.get(i)){
			helper(x, graph, q, visited);
			if (notPossible)
				return;
		}
		visited[i]=2;
		q.add(i);
	}
	public static void main(String[] args) {
		int num = 4;
		int[][] pre = new int[][]{new int[]{1,0},new int[]{2,0},new int[]{3,1},new int[]{3,2}};
		int[] temp = new ClassScheduleII().findOrder(num, pre);
		for(int x:temp){
			System.out.println(x);
		}
	}

}
package Uber;

import java.util.*;
public class BipartiteGraph {
	Queue<Integer> q;
	public static final int NO_COLOR = 0;
    public static final int RED = 1;
    public static final int BLUE = 2;
	public BipartiteGraph(){
		q = new LinkedList<Integer>();
	}
	public boolean isBipartite(int adjacencyMatrix[][], int source){
		int noOfVertices = adjacencyMatrix[0].length;
		int[] colored = new int[noOfVertices+1];
		Arrays.fill(colored, NO_COLOR);
		colored[source] = RED;
		q.add(source);
		while(!q.isEmpty()){
			int element = q.poll();
			int neighbour = 1;
			while(neighbour<=noOfVertices){
				if(adjacencyMatrix[element][neighbour]==1){
					if(colored[neighbour]==colored[element]){
						return false;
					}else if(colored[neighbour]==NO_COLOR){
						colored[neighbour] = colored[element]==RED?BLUE:RED;
						q.add(neighbour);
					}
				}
				neighbour++;
			}
		}
		return true;
	}
}

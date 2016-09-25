package Uber;
public class AlienDictonary {
	int count = 0;
	public String alienOrder(String[] words) {
        boolean[][] graph = new boolean[26][26];
        int[] status = new int[26];
        //int count = 0;
        char[] result = new char[26];
        buildGraph(words, graph, status);
        for(int i=0;i<26;i++){
        	if(status[i]==1 && !dfs(i, graph, status, result)){
        		return "";
        	}
        }
        return new String(result, 0, count);
    }

	
	private boolean dfs(int i, boolean[][] graph, int[] status, char[] result) {
		if(status[i]==2){
			return false;
		}
		status[i]=2;
		for(int j=0;j<26;j++){
			if(graph[i][j] && status[j]!=3 && !dfs(j, graph, status, result)){
				return false;
			}
		}
		status[i] = 3;
		result[count++] = (char)(i+'a');
		return true;
	}


	private void buildGraph(String[] words, boolean[][] graph, int[] status) {
		for(int i=0;i<words.length;i++){
			for(char ch:words[i].toCharArray()){
				status[ch-'a']=1;
			}
			if(i>0){
				for(int j=0;j<Math.min(words[i-1].length(), words[i].length());j++){
					char c1=words[i].charAt(j);
					char c2=words[i-1].charAt(j);
					if(c1!=c2){
						graph[c1-'a'][c2-'a'] = true;
						break;
					}
				}
			}
		}
		
	}


	public static void main(String[] args) {
		String[] temp = new String[]{"za","zb","ca","cb"};
		System.out.println(new AlienDictonary().alienOrder(temp));
	}
}

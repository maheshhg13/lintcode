package LinkedIn.Interview;

public class CommonCharacters {
	public int countCommonCharacters(String[] inputs) {
		if(inputs==null || inputs.length==0){
			return 0;
		}
		int[] counts = new int[26];
		for(String x:inputs){
			boolean[] exists = new boolean[26];
			for(int i=0;i<x.length();i++){
				int index = x.charAt(i)-'a';
				if(!exists[index]){
					exists[index] = true;
					++counts[index];
				}
			}
		}
		int result = 0;
		for(int x:counts){
			if(x==inputs.length){
				result++;
			}
		}
		return result;
	}

}

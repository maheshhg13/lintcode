package LinkedIn.Interview;

public class StrictlyGreater {
	public char smallest_character(String str, char c){
		int l=0;
		int r=str.length()-1;
		char ret = str.charAt(0);
		while(l<=r){
			int mid = (r+l)/2;
			if(str.charAt(mid)>c){
				ret = str.charAt(mid);
				r-=1;
			}else{
				l+=1;
			}
		}
		return ret;
	}
	public static void main(String[] args) {
		String temp = "cfjpv";
		char search = 'c';
		System.out.println(new StrictlyGreater().smallest_character(temp, search));
	}
}

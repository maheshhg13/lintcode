package LinkedIn.Interview;

public class RomanVSInteger {
	public String IntegerToRoman(int num){
		String[] str = new String[] {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
		int[] val = new int[] {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<val.length;i++){
			while(num>val[i]){
				sb.append(str[i]);
				num-=val[i];
			}
		}
		return sb.toString();
	}
	public int RomanToIntger(String input){
		int val=0;
		for(int i=0;i<input.length();i++){
			if((i+1)<input.length() && (get(input.charAt(i))<get(input.charAt(i+1)))){
				val-=get(input.charAt(i));
			}else{
				val+=get(input.charAt(i));
			}
		}
		return val;
	}
	private int get(char ch){
        int val = 0;
        switch(ch){
            case 'I':
                val = 1;
                break;
            case 'V':
                val = 5;
                break;
            case 'X':
                val = 10;
                break;
            case 'L':
                val = 50;
                break;
            case 'C':
                val = 100;
                break;
            case 'D':
                val = 500;
                break;
            case 'M':
                val = 1000;
                break;
        }
        return val;
    }
}

package Uber;
import java.util.*;
public class SecretSanta {
	public String[] generateAssignments(String[] names){
		if(names==null){
			return null;
		}else if(names.length==0){
			return new String[0];
		}else if(names.length==1){
			return names;
		}
		int num = names.length;
		boolean[] choosen = new boolean[num];
		boolean[] santa = new boolean[num];
		Random ran = new Random();
		String[] result = new String[num];
		int pos = 0;
		int t = 0;
		while(true){
			t++;
			int r1 = ran.nextInt(num);
			int r2 = ran.nextInt(num);
		
			String p1 = names[r1];
			String p2 = names[r2];
			
			if((!p1.equals(p2)) && santa[r1]==false && choosen[r2]==false){
				if(!p1.equals(names[pos])){
					System.out.println("Adding: "+p1+" at pos: "+pos+" After iter: "+t);
					result[pos]=p1;
					pos++;
					santa[r1]=true;
					choosen[r2] = true;
					if(pos==num){
						System.out.println("Breaking after: "+t);
						break;
					}
				}
			}
		}
		return result;
	}
	
	private String[] shuffle(String[] arr){
		String[] m = new String[arr.length];
		Random ran = new Random();
		for(int i=arr.length-1;i>0;i--){
			int indx = ran.nextInt(i+1);
			m[i] = arr[indx];
			m[indx] = arr[i];
		}
		return m;
	}
	
	public static void main(String[] args) {
		String[] names = {"Kyle", "Kenny", "Eric", "Stan", "Stewie","Brian"};
		String[] temp = new SecretSanta().generateAssignments(names);
		for(String x:temp){
			System.out.println(x);
		}
	}
}

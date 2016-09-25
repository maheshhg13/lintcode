package Uber;

import java.util.*;

public class FlattenJson {

	public String flatten(List<Pair> pairs){
		String ret = "";
		for(Pair x:pairs){
			if(x.data.isNum){
				ret+=x.alpha+":"+x.data.getNumber()+" ";
			}else{
				String temp = flatten(x.data.getPair()).trim();
				String temps[] = temp.split(" ");
				for(String m:temps){
					ret+=x.alpha+":"+m+" ";
				}
			}
		}
		return ret.trim();
	}
	public static void main(String[] args) {
		List<Pair> pairs = new ArrayList<>();
		Pair p = new Pair('p', new Data(1));
		Pair q = new Pair('q', new Data(Arrays.asList(new Pair('a', new Data(Arrays.asList(new Pair('r', new Data(10)), new Pair('s', new Data(11))))), new Pair('b', new Data(2)))));
		pairs.addAll(Arrays.asList(p, q));
		System.out.println("|"+new FlattenJson().flatten(pairs)+"|");
	}
}

class Data{
	boolean isNum, isPair;
	int num;
	List<Pair> data;
	public Data(int x){
		isNum = true;
		num = x;
	}
	public Data(List<Pair> x){
		data = x;
		isPair = true;
	}
	public boolean isNumber(){
		return isNum;
	}
	public boolean isPairData(){
		return isPair;
	}
	public List<Pair> getPair(){
		return isPair?data:null;
	}
	public Integer getNumber(){
		return isNum?num:null;
	}
}
class Pair{
	char alpha;
	Data data;
	public Pair(char x, Data d){
		alpha = x;
		data = d;
	}
}

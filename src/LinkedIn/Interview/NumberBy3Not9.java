package LinkedIn.Interview;

import java.util.*;
public class NumberBy3Not9 {
	public List<Integer> find_elements_div3_not9(int n)
	{
		if (n < 3)
			return new ArrayList<Integer>();

		boolean[] flags = new boolean[n + 1];
		flags[3] = true;

		int mult = 2;
		List<Integer> res = new ArrayList<Integer>();
		res.addAll(Arrays.asList(1,3));
		while (mult * 3 <= n) {

			if (!flags[mult]) {
				res.add(mult * 3);
			}

			flags[mult * 3] = true;
			mult = mult + 1;
		}

		return res;
	}
	public static void main(String[] args) {
		List<Integer> result = new NumberBy3Not9().find_elements_div3_not9(20);
		for(int x:result){
			System.out.println(x+" ");
		}
	}
}

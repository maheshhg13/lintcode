package Ladder.Level8;

import java.util.ArrayList;

public class Permutations {
	public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> nums) {
		ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
		if (nums == null || nums.size() == 0) {
			return ret;
		}
		permute(nums, ret, new ArrayList<Integer>());
		return ret;
	}

	private void permute(ArrayList<Integer> nums, ArrayList<ArrayList<Integer>> ret, ArrayList<Integer> curr) {
		if (curr.size() == nums.size()) {
			ret.add(new ArrayList<Integer>(curr));
			return;
		}
		for (int i = 0; i < nums.size(); i++) {
			if (curr.contains(nums.get(i))) {
				continue;
			}
			curr.add(nums.get(i));
			permute(nums, ret, curr);
			curr.remove(curr.size() - 1);
		}
	}
}

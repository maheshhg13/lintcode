package Ladder.Level2;

import java.util.ArrayList;
import java.util.Arrays;

public class FourSum {
	public class Solution {
		/**
		 * @param numbers
		 *            : Give an array numbersbers of n integer
		 * @param target
		 *            : you need to find four elements that's sum of target
		 * @return : Find all unique quadruplets in the array which gives the
		 *         sum of zero.
		 */
		public ArrayList<ArrayList<Integer>> fourSum(int[] numbers, int target) {
			ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
			if (numbers.length < 4) {
				return arr;
			}
			Arrays.sort(numbers);
			for (int one = 0; one < numbers.length; one++) {
				for (int two = one + 1; two < numbers.length; two++) {
					for (int three = two + 1; three < numbers.length; three++) {
						int sum = numbers[one] + numbers[two] + numbers[three];
						int four = three + 1;
						while (four < numbers.length) {
							if (numbers[four] + sum == target) {
								ArrayList<Integer> temp = new ArrayList<Integer>();
								temp.add(numbers[one]);
								temp.add(numbers[two]);
								temp.add(numbers[three]);
								temp.add(numbers[four]);
								if (!arr.contains(temp))
									arr.add(temp);
							}else if(numbers[four] + sum > target){
							    break;
							}
							four++;
						}

					}
				}
			}
			return arr;
		}
	}

}

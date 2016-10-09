package LinkedIn.Interview;

public class CanIWin {
	public boolean canIWin(int[] numbers, int target){
		if(numbers.length==0){
			return false;
		}
		boolean[] used = new boolean[numbers.length];
		return helper(numbers, used, target);
	}

	private boolean helper(int[] numbers, boolean[] used, int target) {
		boolean opponentWin = true;
		for(int i=0;i<numbers.length;i++){
			if(used[i]){
				continue;
			}
			int num = numbers[i];
			if(num>=target){
				return true;
			}
			used[i] = true;
			opponentWin = helper(numbers, used, target-num);
			used[i] = false;
			if(!opponentWin){
				break;
			}
		}
		return !opponentWin;
	}
}

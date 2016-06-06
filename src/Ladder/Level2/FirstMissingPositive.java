package Ladder.Level2;

public class FirstMissingPositive {
	public int firstMissingPositive(int[] A) {
        boolean[] array = new boolean[A.length + 1];
        for (int a : A) {
            if (a <= A.length && a > 0) {
                array[a] = true;
            }
        }
        for (int i = 1; i < array.length; i++) {
            if (array[i] == false) {
                return i;
            }
        }
        return A.length + 1;
    }
}

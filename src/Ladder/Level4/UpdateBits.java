package Ladder.Level4;

public class UpdateBits {
	public int updateBits(int n, int m, int i, int j) {
        int mask;
        if (j < 31) {
            mask = ~((1 << (j + 1)) - (1 << i));
        } else {
            mask = (1 << i) - 1;
        }
        return (m << i) + (mask & n);
    }
}

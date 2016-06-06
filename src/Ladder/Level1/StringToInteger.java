package Ladder.Level1;

public class StringToInteger {
	public static int atoi(String str) {
		if (str == null || str.length() == 0)
			return 0;

		boolean negative = false;
		int i = 0;
		while (i < str.length() && (str.charAt(i) == ' ')) {
			i++;
		}

		if (str.charAt(i) == '-') {
			negative = true;
			i++;
		} else if (str.charAt(i) == '+') {
			i++;
		}

		String temp = "";

		while (i < str.length() && Character.isDigit(str.charAt(i))) {
			temp += str.charAt(i) + "";
			i++;
		}
		if (temp.length() == 0)
			return 0;

		try {
			int ret = Integer.parseInt(temp);
			if (negative) {
				return -1 * ret;
			}
			return ret;
		} catch (Exception E) {
			if (negative) {
				return Integer.MIN_VALUE;
			}
			return Integer.MAX_VALUE;
		}
	}

	public static void main(String[] args) {
		System.out.println(atoi("    -10"));
	}
}

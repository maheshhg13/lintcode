package lintcode;

//Given k strings, find the longest common prefix (LCP).
//
//Example
//For strings "ABCD", "ABEF" and "ACEF", the LCP is "A"
//
//For strings "ABCDEFG", "ABCEFG" and "ABCEFA", the LCP is "ABC"

public class LongestCommonPrefix {
	private boolean hasPrefix(String pre, String[] strs) {
		for (String s : strs) {
			if (!s.startsWith(pre)) {
				return false;
			}
		}
		return true;
	}

	public String longestCommonPrefix(String[] strs) {
		if (strs.length < 1)
			return "";
		String temp = strs[0];
		String maxPre = "";
		for (int i = 1; i <= temp.length(); i++) {
			String pre = temp.substring(0, i);
			if (hasPrefix(pre, strs)) {
				maxPre = pre;
			}
		}
		return maxPre;
	}
}

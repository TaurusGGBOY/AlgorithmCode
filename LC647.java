// dp¸ü¿ì

class Solution {
	public int countSubstrings(String s) {
		int count = 0;
		for (int i = 1; i <= s.length(); i++) {
			for (int j = 0; j < s.length() - i + 1; j++) {
				if (judge(s.substring(j, j + i)))
					count++;
			}
		}
		return count;
	}

	public boolean judge(String str) {
		for (int i = 0; i < str.length() / 2; i++) {
			if (str.charAt(i) != str.charAt(str.length() - i - 1))
				return false;
		}
		return true;
	}
}
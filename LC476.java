class Solution {
	public int findComplement(int num) {
		String string = Integer.toBinaryString(num);
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < string.length(); i++)
			stringBuilder.append("1");
		return num ^ Integer.parseInt(stringBuilder.toString(), 2);
	}
}
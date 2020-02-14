public class Solution {
	// you need to treat n as an unsigned value
	public int hammingWeight(int n) {
		String temp = Integer.toBinaryString(n);
		int count=0;
		for(int i=0;i<temp.length();i++)
		{
			count+=temp.charAt(i)=='1'?1:0;
		}
		return count;
	}
}
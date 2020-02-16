class Solution {
	public int[] constructArr(int[] a) {
		if(a==null)
			return null;
		if(a.length==0)
			return a;
		int[] left = new int[a.length];
		int[] right = new int[a.length];
		int leftRes =1;
		int rightRes=1;
		for(int i=0;i<a.length;i++)
		{
			leftRes*=a[i];
			rightRes*=a[a.length-1-i];
			left[i]=leftRes;
			right[a.length-1-i]=rightRes;
		}
		int[] res = new int[a.length];
		res[0]=right[1];
		res[res.length - 1] = left[res.length - 2];
		for(int i=1;i<res.length-1;i++)
		{
			res[i] = left[i - 1] * right[i + 1];
		}
		return res;
	}
}
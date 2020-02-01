import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

// 还要理解

class Solution {
	public int[][] reconstructQueue(int[][] people) {
		Arrays.sort(people, new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				if (a[0] == b[0])
					return a[1] - b[1];
				return -a[0] + b[0];
			}
		});
		List<int[]> outList = new ArrayList<int[]>();
		for (int[] p : people)
			outList.add(p[1], p);
		return outList.toArray(new int[people.length][2]);
	}
}
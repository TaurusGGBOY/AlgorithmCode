import java.util.HashSet;
import java.util.Set;

class Solution {
	public int repeatedNTimes(int[] A) {
		// for (int j = 0; j < 3; j++)
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < A.length; i++) {
			try {
				if (set.contains(A[i]))
					return A[i];
				set.add(A[i]);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return 0;
	}
}
import java.util.ArrayList;
import java.util.List;

class Solution {
	private List<List<Integer>> listlist = new ArrayList<>();

	public List<List<Integer>> permute(int[] nums) {
		int depth = 1;
		int[] isValidate = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			depth = 1;
			isValidate[i] = 1;
			List<Integer> list = new ArrayList<>();
			list.add(nums[i]);
			dfs(nums, isValidate, depth + 1, list);
			isValidate[i] = 0;
		}
		return listlist;
	}

	private void dfs(int[] nums, int[] isValidate, int depth, List<Integer> list) {
		if (depth == nums.length + 1) {
			// System.out.println(depth);
			// System.out.println(list.toString());
			List<Integer> newList = new ArrayList<>();
			newList.addAll(list);
			listlist.add(newList);
		}
		for (int i = 0; i < nums.length; i++) {

			if (isValidate[i] == 0) {
				isValidate[i] = 1;
				list.add(nums[i]);
				dfs(nums, isValidate, depth + 1, list);
				list.remove(list.size() - 1);
				isValidate[i] = 0;
			}
		}
	}

}
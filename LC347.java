import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
	public List<Integer> topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		Queue<Entry<Integer, Integer>> queue = new PriorityQueue<Entry<Integer, Integer>>(k,
				new Comparator<Entry<Integer, Integer>>() {
					public int compare(Entry<Integer, Integer> entry1, Entry<Integer, Integer> entry2) {
						return entry1.getValue() - entry2.getValue();
					}
				});
		for (int num : nums) {
			int temp = 0;
			try {
				temp = map.get(num);
			} catch (Exception e) {
				// TODO: handle exception
			}
			temp++;
			map.put(num, temp);
		}
		int listCount = 0;
		for (Entry<Integer, Integer> entry : map.entrySet()) {
			listCount++;
			if (listCount <= k) {
				queue.add(entry);
			} else {
				Entry<Integer, Integer> tempPeekEntry = queue.peek();
				if (entry.getValue() > tempPeekEntry.getValue()) {
					queue.poll();
					queue.add(entry);
				}
			}
			// System.out.println(queue.toString());
		}
		List<Integer> list = new ArrayList<>();
		for (Entry<Integer, Integer> entry : queue) {
			list.add(entry.getKey());
		}
		return list;

	}
}
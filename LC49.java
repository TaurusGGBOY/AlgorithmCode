import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

class Solution {
	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> list = new ArrayList<List<String>>();
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		for (String str : strs) {
			char[] ca = str.toCharArray();
			Arrays.sort(ca);
			String tempString = String.valueOf(ca);
			if (map.containsKey(tempString)) {
				List<String> tempList = new ArrayList<String>();
				tempList = map.get(tempString);
				tempList.add(str);
				map.put(tempString, tempList);
			} else {
				List<String> tempList = new ArrayList<String>();
				tempList.add(str);
				map.put(tempString, tempList);
			}
		}
		for (Entry<String, List<String>> entry : map.entrySet()) {
			list.add(entry.getValue());
		}
		return list;
	}
}
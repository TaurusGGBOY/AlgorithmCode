import java.util.*;

class Solution {
    public String[] reorderLogFiles(String[] logs) {
        List<String> list1 = new ArrayList<>(), list2 = new ArrayList<>();
        for (String log : logs) {
            if (Character.isDigit(log.charAt(log.indexOf(" ") + 1))) list2.add(log);
            else list1.add(log);
        }
        Collections.sort(list1, (s1, s2) -> {
            int ans = s1.substring(s1.indexOf(" ") + 1).compareTo(s2.substring(s2.indexOf(" ") + 1));
            if (ans != 0) return ans;
            String prefix1 = s1.substring(0, s1.indexOf(" "));
            String prefix2 = s2.substring(0, s2.indexOf(" "));
            return prefix1.compareTo(prefix2);
        });
        String[] res = new String[logs.length];
        for (int i = 0; i < list1.size(); i++) res[i] = list1.get(i);
        for (int i = 0; i < list2.size(); i++) res[i + list1.size()] = list2.get(i);
        return res;
    }
}
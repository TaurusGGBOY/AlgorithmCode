import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    static public void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = Integer.parseInt(scanner.nextLine());
        Set<String> set = new HashSet<>();
        for (int i = 0; i < k; i++) {
            set.add(scanner.nextLine());
        }
        int n = Integer.parseInt(scanner.nextLine());
        Map<Integer, Set<String>> map = new HashMap();

        Set<String> total = new HashSet<>();
        for (String s : set) {
            String[] split = s.split(" ");
            split[1] = split[1].replaceAll("-", "//");
            int day = (int)(new Date(split[1]).getTime()/(60*60*24));
            Set<String> newSet = map.getOrDefault(day, new HashSet<>());
            newSet.add(split[0]);
            total.add(split[0]);
            map.put(day, newSet);
        }
        if (total.size() < n) {
            System.out.println(-1);
            return;
        }

        TreeMap<Integer, Set<String>> treeMap = new TreeMap<>(map);
        List<AbstractMap.SimpleEntry<Integer, Set<String>>> list = new ArrayList<>();
        for (Map.Entry<Integer, Set<String>> entry : treeMap.entrySet()) {
            list.add(new AbstractMap.SimpleEntry<>(entry.getKey(), entry.getValue()));
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        int lastDay  =dateFormat.parse(dateFormat.format(treeMap.lastKey())).getTime()/(60*60*24);
        int firstDay  =dateFormat.parse(dateFormat.format(treeMap.firstKey())).getTime()/(60*60*24);

        int l = 1;
        int r = lastDay - firstDay + 1;
        System.out.println(l + "  " + r);
        while (l < r) {
            int m = l + (l + r) / 2;
            System.out.println(l + " " + m + " " + r);
            Map<String, Integer> users = new HashMap<>();
            int pos = 0;
            while (pos < list.size()) {
                Set<String> entrySet = list.get(pos).getValue();
                for (String s : entrySet) users.merge(s, 1, Integer::sum);
                if (list.get(pos).getKey() - list.get(0).getKey() >= m) break;
                pos++;
            }
            if (users.size() >= n) {
                r = m;
                continue;
            }
            int left = 0;
            boolean flag = true;
            for (int i = pos; i < list.size(); i++) {
                Set<String> entrySet = list.get(pos).getValue();
                for (String s : entrySet) users.merge(s, 1, Integer::sum);
                while (list.get(pos).getKey() - list.get(left).getKey() > m) {
                    Set<String> leftSet = list.get(pos).getValue();
                    for (String s : leftSet) {
                        int value = users.get(s);
                        value--;
                        users.put(s, value);
                        if (value == 0) users.remove(s);
                    }
                    left++;
                }
                if (users.size() >= n) {
                    r = m;
                    flag = false;
                    break;
                }
            }
            if (flag) l = m + 1;
        }
        System.out.println(l);

    }
}

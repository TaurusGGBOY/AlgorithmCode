//显示详情
//执行用时：
//873 ms
//, 在所有 Java 提交中击败了
//5.02%
//的用户
//内存消耗：
//39 MB
//, 在所有 Java 提交中击败了
//97.67%
//的用户
import java.util.*;

class Solution {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<AbstractMap.SimpleEntry<Character, Integer>> queue = new PriorityQueue<>(new Comparator<AbstractMap.SimpleEntry<Character, Integer>>() {
            @Override
            public int compare(AbstractMap.SimpleEntry<Character, Integer> o1, AbstractMap.SimpleEntry<Character, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        Map<Character, AbstractMap.SimpleEntry<Character, Integer>> map = new HashMap<>();

        for (char task : tasks) {
            AbstractMap.SimpleEntry<Character, Integer> entry = map.getOrDefault(task, new AbstractMap.SimpleEntry<Character, Integer>(task, 0));
            entry.setValue(entry.getValue() + 1);
            map.put(task, entry);
        }

        queue.addAll(map.values());

        int[] lastPos = new int[26];
        Arrays.fill(lastPos, -n - 1);

        int pos = 0;
//        System.out.println("开始");
        while (!queue.isEmpty()) {
            List<AbstractMap.SimpleEntry<Character, Integer>> list = new ArrayList<>();
//            System.out.println("一次");
//            System.out.println(queue.toString());
//            System.out.println(Arrays.toString(lastPos));
            while (!queue.isEmpty()) {
                AbstractMap.SimpleEntry<Character, Integer> poll = queue.poll();
                if (pos - lastPos[poll.getKey() - 'A'] > n) {
                    lastPos[poll.getKey() - 'A'] = pos;
                    if (poll.getValue() > 1) {
                        poll.setValue(poll.getValue() - 1);
                        list.add(poll);
                    }
                    break;
                }
                list.add(poll);
            }
            queue.addAll(list);
//            System.out.println(queue.toString());
//            System.out.println(Arrays.toString(lastPos));
            pos++;
        }
        return pos;
    }
}
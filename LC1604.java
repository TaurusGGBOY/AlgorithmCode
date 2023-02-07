import java.util.*;

class Solution {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        Map<String, Queue<Integer>> timeMap = new HashMap<>();
        for (int i = 0; i < keyName.length; i++) {
            Queue<Integer> q = timeMap.getOrDefault(keyName[i], new PriorityQueue<>());
            q.offer(getTime(keyTime[i]));
            timeMap.put(keyName[i], q);
        }

        Map<String, Queue<Integer>> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        for (Map.Entry<String, Queue<Integer>> entry : timeMap.entrySet()) {
            Queue<Integer> q = entry.getValue();
            while (!q.isEmpty()) {
                if (set.contains(entry.getKey())) break;
                int time = q.poll();
                Queue<Integer> queue = map.getOrDefault(entry.getKey(), new LinkedList<>());
                while (!queue.isEmpty() && queue.peek() + 60 < time) queue.poll();
                queue.offer(time);
                if (queue.size() >= 3) set.add(entry.getKey());
                map.put(entry.getKey(), queue);
            }
        }
//        System.out.println(map);
        List<String> list = new ArrayList<>(set);
        Collections.sort(list);
        return list;
    }

    int getTime(String keyTime) {
        String[] split = keyTime.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }
}
import java.util.*;

class Solution {
    public String reorganizeString(String S) {
        PriorityQueue<AbstractMap.SimpleEntry<Character, Integer>> queue = new PriorityQueue<>(new Comparator<AbstractMap.SimpleEntry<Character, Integer>>() {
            @Override
            public int compare(AbstractMap.SimpleEntry<Character, Integer> o1, AbstractMap.SimpleEntry<Character, Integer> o2) {
                return o2.getKey() - o1.getKey();
            }
        });
        Map<Character, AbstractMap.SimpleEntry<Character, Integer>> map = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            map.put((char) (i + 'a'), new AbstractMap.SimpleEntry<Character, Integer>((char) (i + 'a'), 0));
        }
        for (char c : S.toCharArray()) {
            AbstractMap.SimpleEntry<Character, Integer> characterIntegerSimpleEntry = map.get(c);
            characterIntegerSimpleEntry.setValue(characterIntegerSimpleEntry.getValue() + 1);
        }
        for (int i = 0; i < 26; i++) {
            if (map.get((char) (i + 'a')).getValue() != 0)
                queue.add(map.get((char) (i + 'a')));
        }
//        System.out.println(queue.toString());
        StringBuilder stringBuilder = new StringBuilder();
        while (!queue.isEmpty()) {
            AbstractMap.SimpleEntry<Character, Integer> poll;
            if (queue.size() == 1) {
                poll = queue.poll();
                stringBuilder.append(poll.getKey());
                if (poll.getValue() == 1) {
                    break;
                }
                poll.setValue(poll.getValue() - 1);
                queue.add(poll);
                continue;
            }
            poll = queue.poll();
            AbstractMap.SimpleEntry<Character, Integer> poll2 = queue.poll();
            stringBuilder.append(poll.getKey());
            if (poll.getValue() > 1) {
                poll.setValue(poll.getValue() - 1);
                queue.add(poll);
            }

            stringBuilder.append(poll2.getKey());
            if (poll2.getValue() > 1) {
                poll2.setValue(poll2.getValue() - 1);
                queue.add(poll2);
            }
        }
        char[] res = stringBuilder.toString().toCharArray();
        for (int i = 0; i < res.length - 1; i++) {
            if (res[i] == res[i + 1])
                return "";
        }
        return stringBuilder.toString();
    }
}
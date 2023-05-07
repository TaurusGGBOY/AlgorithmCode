import java.util.*;

class Solution {
    public int[] getOrder(int[][] tasks) {
        Map<Integer, AbstractMap.SimpleEntry<Integer, Integer>> map = new HashMap<>();
        Queue<Map.Entry<Integer, AbstractMap.SimpleEntry<Integer, Integer>>> timeQue = new PriorityQueue<>(new Comparator<Map.Entry<Integer, AbstractMap.SimpleEntry<Integer, Integer>>>() {
            @Override
            public int compare(Map.Entry<Integer, AbstractMap.SimpleEntry<Integer, Integer>> o1, Map.Entry<Integer, AbstractMap.SimpleEntry<Integer, Integer>> o2) {
                AbstractMap.SimpleEntry<Integer, Integer> value1 = o1.getValue();
                AbstractMap.SimpleEntry<Integer, Integer> value2 = o2.getValue();
                return value1.getKey() - value2.getKey();
            }
        });
        Queue<Map.Entry<Integer, AbstractMap.SimpleEntry<Integer, Integer>>> shortedQue = new PriorityQueue<>(new Comparator<Map.Entry<Integer, AbstractMap.SimpleEntry<Integer, Integer>>>() {
            @Override
            public int compare(Map.Entry<Integer, AbstractMap.SimpleEntry<Integer, Integer>> o1, Map.Entry<Integer, AbstractMap.SimpleEntry<Integer, Integer>> o2) {
                AbstractMap.SimpleEntry<Integer, Integer> value1 = o1.getValue();
                AbstractMap.SimpleEntry<Integer, Integer> value2 = o2.getValue();
                if (value1.getValue().equals(value2.getValue())) {
                    return o1.getKey() - o2.getKey();
                }
                return value1.getValue() - value2.getValue();
            }
        });
        for (int i = 0; i < tasks.length; i++) {
            AbstractMap.SimpleEntry<Integer, Integer> pair = new AbstractMap.SimpleEntry<Integer, Integer>(tasks[i][0], tasks[i][1]);
            map.put(i, pair);
        }
        timeQue.addAll(map.entrySet());
//        // 测试
//        System.out.println("timeque test");
//        for (Map.Entry<Integer, AbstractMap.SimpleEntry<Integer, Integer>> entry : timeQue) {
//            System.out.println(entry.toString());
//        }
//        System.out.println("short test");
//
//        shortedQue.addAll(map.entrySet());
//        for (Map.Entry<Integer, AbstractMap.SimpleEntry<Integer, Integer>> integerSimpleEntryEntry : shortedQue) {
//            System.out.println(integerSimpleEntryEntry.toString());
//        }

//        System.out.println("时间队列：" + timeQue.toString());
//        System.out.println("时间队列：" + timeQue.size());

        int currentTime = timeQue.iterator().next().getValue().getKey();
        List<Integer> res = new ArrayList<>();
        while (!timeQue.isEmpty() || !shortedQue.isEmpty()) {
            if (shortedQue.isEmpty()) {
                currentTime = Math.max(currentTime, timeQue.iterator().next().getValue().getKey());
            }
            if (!timeQue.isEmpty()) {
//                System.out.println("现在时间"+currentTime);
                Iterator<Map.Entry<Integer, AbstractMap.SimpleEntry<Integer, Integer>>> iterator1 = timeQue.iterator();
                while (iterator1.hasNext()) {
                    Map.Entry<Integer, AbstractMap.SimpleEntry<Integer, Integer>> next = iterator1.next();
                    if (next.getValue().getKey() <= currentTime) {
                        shortedQue.add(next);
                        iterator1.remove();
                    } else {
                        break;
                    }
                }
//                System.out.println("此时time队列：" + timeQue.toString());
//                System.out.println("此时shortest队列：" + shortedQue.toString());
            }
            Iterator<Map.Entry<Integer, AbstractMap.SimpleEntry<Integer, Integer>>> iterator2 = shortedQue.iterator();
            while (iterator2.hasNext()) {
                Map.Entry<Integer, AbstractMap.SimpleEntry<Integer, Integer>> next = iterator2.next();
                res.add(next.getKey());
                currentTime += next.getValue().getValue();
                iterator2.remove();
                break;
            }
        }
//        System.out.println("数组：" + res);
        // 输入：
        //[[35,36],[11,7],[15,47],[34,2],[47,19],[16,14],[19,8],[7,34],[38,15],[16,18],[27,22],[7,15],[43,2],[10,5],[5,4],[3,11]]
        //输出：
        //[15,14,13,1,6,3,12,5,8,11,9,4,10,7,0,2]
        //预期：
        //[15,14,13,1,6,3,5,12,8,11,9,4,10,7,0,2]
        // 5=16=14
        // 12=43=2
        // 3 14 18 23 30 38 40
        // 15=3=11 14=5=4 13=10=5 1=11=7 6=19=8 3=34=2
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }
}
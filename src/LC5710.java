import java.util.AbstractMap;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int getNumberOfBacklogOrders(int[][] orders) {
        PriorityQueue<AbstractMap.SimpleEntry<Integer, Integer>> buy = new PriorityQueue<>(new Comparator<AbstractMap.SimpleEntry<Integer, Integer>>() {
            @Override
            public int compare(AbstractMap.SimpleEntry<Integer, Integer> o1, AbstractMap.SimpleEntry<Integer, Integer> o2) {
                return o2.getKey() - o1.getKey();
            }
        });
        PriorityQueue<AbstractMap.SimpleEntry<Integer, Integer>> sell = new PriorityQueue<>(new Comparator<AbstractMap.SimpleEntry<Integer, Integer>>() {
            @Override
            public int compare(AbstractMap.SimpleEntry<Integer, Integer> o1, AbstractMap.SimpleEntry<Integer, Integer> o2) {
                return o1.getKey() - o2.getKey();
            }
        });
        for (int[] order : orders) {
            if (order[2] == 0) {
                System.out.println("买 要买最便宜的");
                // 如果销售订单为空 则无法采购
                while (order[1] > 0) {
                    if (sell.isEmpty()) {
                        buy.offer(new AbstractMap.SimpleEntry<>(order[0], order[1]));
                        break;
                    } else {
                        AbstractMap.SimpleEntry<Integer, Integer> poll = sell.poll();
                        System.out.println(poll.getKey() + " " + poll.getValue());
                        if (poll.getKey() <= order[0]) {
                            if (poll.getValue() <= order[1]) {
                                order[1] -= poll.getValue();
                            } else {
                                poll.setValue(poll.getValue() - order[1]);
                                order[1] = 0;
                                sell.offer(poll);
                            }
                        } else {
                            sell.offer(poll);
                            buy.offer(new AbstractMap.SimpleEntry<>(order[0], order[1]));
                            break;
                        }
                    }
                }
            } else {
                System.out.println("卖 要卖最贵的");
                while (order[1] > 0) {
                    if (buy.isEmpty()) {
                        sell.offer(new AbstractMap.SimpleEntry<>(order[0], order[1]));
                        break;
                    } else {
                        AbstractMap.SimpleEntry<Integer, Integer> poll = buy.poll();
                        System.out.println(poll.getKey() + " " + poll.getValue());
                        if (poll.getKey() >= order[0]) {
                            if (poll.getValue() <= order[1]) {
                                order[1] -= poll.getValue();
                            } else {
                                poll.setValue(poll.getValue() - order[1]);
                                order[1] = 0;
                                buy.offer(poll);
                            }
                        } else {
                            buy.offer(poll);
                            sell.offer(new AbstractMap.SimpleEntry<>(order[0], order[1]));
                            break;
                        }
                    }
                }
            }
        }
        long count = 0;
        while (!buy.isEmpty()) {
            int value = buy.poll().getValue();
            count += value;
            System.out.print(value + " ");
        }
        while (!sell.isEmpty()) {
            int value = sell.poll().getValue();
            count += value;
            System.out.print(value + " ");
        }
        System.out.print(count);
        System.out.println();
        return (int) (count % 1000000007);
    }
}
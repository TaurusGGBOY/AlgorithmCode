import java.util.*;

class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        PriorityQueue<AbstractMap.SimpleEntry<Integer, Integer>> idleServer = new PriorityQueue<>(new Comparator<AbstractMap.SimpleEntry<Integer, Integer>>() {
            @Override
            public int compare(AbstractMap.SimpleEntry<Integer, Integer> o1, AbstractMap.SimpleEntry<Integer, Integer> o2) {
                if (o1.getValue().equals(o2.getValue())) {
                    return o1.getKey() - o2.getKey();
                }
                return o1.getValue() - o2.getValue();
            }
        });
        for (int i = 0; i < servers.length; i++) {
            idleServer.offer(new AbstractMap.SimpleEntry<>(i, servers[i]));
        }
        PriorityQueue<AbstractMap.SimpleEntry<Integer, Integer>> taskQueue = new PriorityQueue<>(new Comparator<AbstractMap.SimpleEntry<Integer, Integer>>() {
            @Override
            public int compare(AbstractMap.SimpleEntry<Integer, Integer> o1, AbstractMap.SimpleEntry<Integer, Integer> o2) {
                return o1.getValue() - o2.getValue();
            }
        });

        // 按照任务遍历 规则：
        // 如果时间是大于i的 就可以加入到任务队列
        // 如果时间等于i 只加入一个
        // 如果时间小于i 就快进到i时刻
        int[] ans = new int[tasks.length];

        // 阶段1 每秒判断是否加入 和 结束
        // 阶段2 按照queue来加入
        int i = 0;
        for (int t = 0; i < tasks.length; t++) {
            // 任务是否有完成了的
            while (!taskQueue.isEmpty()) {
                AbstractMap.SimpleEntry<Integer, Integer> task = taskQueue.peek();
                if (task.getValue() <= t) {
                    AbstractMap.SimpleEntry<Integer, Integer> poll = taskQueue.poll();
                    idleServer.offer(new AbstractMap.SimpleEntry<>((poll.getKey()), servers[poll.getKey()]));
                } else {
                    break;
                }
            }
            if (idleServer.isEmpty()) {

                AbstractMap.SimpleEntry<Integer, Integer> poll = taskQueue.poll();
                idleServer.offer(new AbstractMap.SimpleEntry<>((poll.getKey()), servers[poll.getKey()]));
                t = poll.getValue();
                while (!taskQueue.isEmpty()) {
                    AbstractMap.SimpleEntry<Integer, Integer> task = taskQueue.peek();
                    if (task.getValue() <= t) {
                        AbstractMap.SimpleEntry<Integer, Integer> temp = taskQueue.poll();
                        idleServer.offer(new AbstractMap.SimpleEntry<>((temp.getKey()), servers[temp.getKey()]));
                    } else {
                        break;
                    }
                }
            }
            // 加任务
            while (i <= t && !idleServer.isEmpty()&& i < tasks.length) {
//                System.out.println("idle: " +idleServer.toString());
//                System.out.println("task: "+ taskQueue.toString());
                AbstractMap.SimpleEntry<Integer, Integer> server = idleServer.poll();
                taskQueue.offer(new AbstractMap.SimpleEntry<>(server.getKey(), t + tasks[i]));
                ans[i] = server.getKey();
//                System.out.println("time: " + t + "; "+i + " " + server.getKey()+" endtime:"+(t+tasks[i]));
                i++;
            }
        }
        return ans;
    }
}

//[31,96,73,90,15,11,1,90,72,9,30,88]
//[87,10,3,5,76,74,38,64,16,64,93,95,60,79,54,26,30,44,64,71]
//[6,9,5,4,10,5,0,8,4,2,11,9,3,7,1,4,4,0,4,0]
//[6,9,5,4,10,5,0,8,4,2,11,9,3,7,1,4,0,4,1,8]

//[338,890,301,532,284,930,426,616,919,267,571,140,716,859,980,469,628,490,195,664,925,652,503,301,917,563,82,947,910,451,366,190,253,516,503,721,889,964,506,914,986,718,520,328,341,765,922,139,911,578,86,435,824,321,942,215,147,985,619,865]
//[773,537,46,317,233,34,712,625,336,221,145,227,194,693,981,861,317,308,400,2,391,12,626,265,710,792,620,416,267,611,875,361,494,128,133,157,638,632,2,158,428,284,847,431,94,782,888,44,117,489,222,932,494,948,405,44,185,587,738,164,356,783,276,547,605,609,930,847,39,579,768,59,976,790,612,196,865,149,975,28,653,417,539,131,220,325,252,160,761,226,629,317,185,42,713,142,130,695,944,40,700,122,992,33,30,136,773,124,203,384,910,214,536,767,859,478,96,172,398,146,713,80,235,176,876,983,363,646,166,928,232,699,504,612,918,406,42,931,647,795,139,933,746,51,63,359,303,752,799,836,50,854,161,87,346,507,468,651,32,717,279,139,851,178,934,233,876,797,701,505,878,731,468,884,87,921,782,788,803,994,67,905,309,2,85,200,368,672,995,128,734,157,157,814,327,31,556,394,47,53,755,721,159,843]
//[26,50,47,11,56,31,18,55,32,9,4,2,23,53,43,0,44,30,6,51,29,51,15,17,34,22,38,33,42,3,25,10,49,51,7,58,16,21,19,31,19,12,41,35,45,52,13,59,47,36,1,28,48,39,24,8,46,20,5,54,27,37,14,57,40,59,8,45,4,51,47,7,58,4,31,23,54,7,9,56,2,46,56,1,17,42,11,30,12,44,14,32,7,10,23,1,29,27,6,10,33,24,19,10,35,30,35,10,17,49,50,36,29,1,48,44,7,11,24,57,42,30,10,55,3,20,38,15,7,46,32,21,40,16,59,30,53,17,18,34,51,11,53,36,57,26,5,36,56,55,31,22,57,7,52,37,31,10,0,51,41,2,32,25,0,7,49,47,13,14,24,57,28,4,45,43,39,38,8,2,44,45,29,25,25,12,54,5,44,30,27,23,26,7,33,58,41,25,52,40,58,9,52,40]
//[26,50,47,11,56,31,18,55,32,9,4,2,23,53,43,0,44,30,6,51,29,51,15,17,22,34,38,33,42,3,25,10,49,51,7,58,16,21,19,31,19,12,41,35,45,52,13,59,47,36,1,28,48,39,24,8,46,20,5,54,27,37,14,57,40,59,8,45,4,51,47,7,58,4,31,23,54,7,9,56,2,46,56,1,17,42,11,30,12,44,14,32,7,10,23,1,29,27,6,10,33,24,19,10,35,30,35,10,17,49,50,36,29,1,48,44,7,11,24,57,42,30,10,55,3,20,38,15,7,46,32,21,40,16,59,30,53,17,18,22,51,11,53,36,57,26,5,36,56,55,31,34,57,7,52,37,31,10,0,51,41,2,32,25,0,7,49,47,13,14,24,57,28,4,45,43,39,38,8,2,44,45,29,25,25,12,54,5,44,30,27,23,26,7,33,58,41,25,52,40,58,9,52,40]
//[26,50,47,11,56,31,18,55,32,9,4,2,23,53,43,0,44,30,6,51,29,51,15,17,34,22,38,33,42,3,25,10,49,51,7,58,16,21,19,31,19,12,41,35,45,52,13,59,47,36,1,28,48,39,24,8,46,20,5,54,27,37,14,57,40,59,8,45,4,51,47,7,58,4,31,23,54,7,9,56,2,46,56,1,17,42,11,30,12,44,14,32,7,10,23,1,29,27,6,10,33,24,19,10,35,30,35,10,17,49,50,36,29,1,48,44,7,11,24,57,42,30,10,55,3,20,38,15,7,46,32,21,40,16,59,30,53,17,18,34,51,11,53,36,57,26,5,36,56,55,31,22,57,7,52,37,31,10,0,51,41,2,32,25,0,7,49,47,13,14,24,57,28,4,45,43,39,38,8,2,44,45,29,25,25,12,54,5,44,30,27,23,26,7,33,58,41,25,52,40,58,9,52,40]
//[26,50,47,11,56,31,18,55,32,9,4,2,23,53,43,0,44,30,6,51,29,51,15,17,22,34,38,33,42,3,25,10,49,51,7,58,16,21,19,31,19,12,41,35,45,52,13,59,47,36,1,28,48,39,24,8,46,20,5,54,27,37,14,57,40,59,8,45,4,51,47,7,58,4,31,23,54,7,9,56,2,46,56,1,17,42,11,30,12,44,14,32,7,10,23,1,29,27,6,10,33,24,19,10,35,30,35,10,17,49,50,36,29,1,48,44,7,11,24,57,42,30,10,55,3,20,38,15,7,46,32,21,40,16,59,30,53,17,18,22,51,11,53,36,57,26,5,36,56,55,31,34,57,7,52,37,31,10,0,51,41,2,32,25,0,7,49,47,13,14,24,57,28,4,45,43,39,38,8,2,44,45,29,25,25,12,54,5,44,30,27,23,26,7,33,58,41,25,52,40,58,9,52,40]
//[26,50,47,11,56,31,18,55,32,9,4,2,23,53,43,0,44,30,6,51,29,51,15,17,22,34,38,33,42,3,25,10,49,51,7,58,16,21,19,31,19,12,41,35,45,52,13,59,47,36,1,28,48,39,24,8,46,20,5,54,27,37,14,57,40,59,8,45,4,51,47,7,58,4,31,23,54,7,9,56,2,46,56,1,17,42,11,30,12,44,14,32,7,10,23,1,29,27,6,10,33,24,19,35,10,30,10,35,17,49,36,50,29,1,48,44,7,11,24,57,42,30,35,55,3,20,38,15,7,46,32,40,21,16,59,30,53,17,18,22,51,11,53,50,57,26,5,56,50,55,31,34,57,7,52,37,31,35,0,51,41,2,32,25,0,7,49,47,13,14,24,57,28,4,45,43,39,38,8,2,44,45,29,25,25,12,54,5,44,30,27,23,26,7,33,58,41,25,52,21,58,9,52,21]
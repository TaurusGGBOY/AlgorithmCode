// TODO：失败
import java.math.BigInteger;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int maxProfit(int[] inventory, int orders) {
        Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i : inventory) {
            queue.add(i);
        }
        queue.add(0);
        int res = 0;
        int remind = orders;
        System.out.println("begin");
        while (remind > 0) {
            int temp = queue.poll();
            System.out.println("res "+res+"temp "+temp);
            int dis = temp - queue.peek();
            if (dis == 0) {
                remind--;
                res = (res + temp) % 1000000007;
                queue.add(temp - 1);
                continue;
            }
            if (dis >= remind) {
//                System.out.println(res);
                res = (new BigInteger(String.valueOf(temp)).add(BigInteger.valueOf(temp - remind + 1)).multiply(BigInteger.valueOf(remind)).divide(BigInteger.valueOf(2)).mod(BigInteger.valueOf(1000000007)).intValue()+res)%1000000007;
//                System.out.println(new BigInteger(String.valueOf(temp)).add(BigInteger.valueOf(temp - remind + 1)).multiply(BigInteger.valueOf(remind)).divide(BigInteger.valueOf(2)));
                return res;
            } else {
                res = new BigInteger(String.valueOf(temp)).add(BigInteger.valueOf(temp - dis + 1)).multiply(BigInteger.valueOf(dis)).divide(BigInteger.valueOf(2)).add(new BigInteger(String.valueOf(res))).mod(BigInteger.valueOf(1000000007)).intValue()%1000000007;;
                queue.add(queue.peek());
                remind -= dis;
            }
        }
        return res;
    }
}
//[497978859,167261111,483575207,591815159]
//        836556809
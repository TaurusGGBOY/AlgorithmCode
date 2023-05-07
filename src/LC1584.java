import java.util.*;

class Solution {
    Map<NewPoint, NewPoint> parents;

    public int minCostConnectPoints(int[][] points) {
        // 直接用parents的个数来表示已经加入并查集的个数
        parents = new HashMap<>();
        Queue<LC1584Point> queue = new PriorityQueue<>(new Comparator<LC1584Point>() {
            @Override
            public int compare(LC1584Point o1, LC1584Point o2) {
                return o1.len - o2.len;
            }
        });
        int res = 0;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                LC1584Point point = new LC1584Point();
                point.len = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                point.x1 = points[i][0];
                point.y1 = points[i][1];
                point.x2 = points[j][0];
                point.y2 = points[j][1];
                queue.add(point);
            }
        }
//        System.out.println(queue.toString());
        while (true) {
            LC1584Point poll = queue.poll();
            if (poll == null)
                break;
            NewPoint point1 = new NewPoint();
            NewPoint point2 = new NewPoint();
            point1.x = poll.x1;
            point1.y = poll.y1;
            point2.x = poll.x2;
            point2.y = poll.y2;
            // 一个是判断是否由环 如果没有环 那么将两个点加入并查集
            // 最后的结束条件是在并查集已经个数为n的情况下 还添加了一条边
            // 让前面的当parents
            if (!parents.containsKey(point1)) {
                parents.put(point1, point1);
            }
            if (!parents.containsKey(point2)) {
                parents.put(point2, point2);
            }
            // 这一段说明有环了 如果有环就放弃
            if (!find(point1).equals(find(point2))) {
                //如果parents.size()==points.length就可以结束了 如果不是环 而且只有一个连通分量了

                if(parents.size()<=points.length){
                    res+=poll.len;
                    if(parents.values().size()==1)
                        break;
                    merge(point1, point2);
                }
            }
        }
        return res;
    }

    void merge(NewPoint parent, NewPoint son) {
        parents.put(find(son), find(parent));
    }

    NewPoint find(NewPoint point) {
        NewPoint temp = parents.get(point);
        if (!temp.equals(point)) {
            return find(temp);
        }
        return parents.get(point);
    }

    private class LC1584Point {
        public int len;
        public int x1;
        public int y1;
        public int x2;
        public int y2;

        @Override
        public String toString() {
            return "len x1 x2 x3 x4 " + len + " " + x1 + " " + y1 + " " + x2 + " " + y2 + "\n";
        }


    }

    private class NewPoint {
        public int x;
        public int y;

        @Override
        public boolean equals(Object obj) {
            if (obj == null)
                return false;
            NewPoint point = (NewPoint) obj;
            return (this.x == point.x) && (this.y == point.y);
        }

        @Override
        public int hashCode() {
            return x + y;
        }

        @Override
        public String toString() {
            return "x,y " + x + " " + y + "\n";
        }
    }
}
//[[0,0],[2,2],[3,10],[5,2],[7,0]]
//        [[3,12],[-2,5],[-4,1]]
//        [[0,0],[1,1],[1,0],[-1,1]]
//        [[-1000000,-1000000],[1000000,1000000]]
//        [[0,0]]
//        [[2,-3],[-17,-8],[13,8],[-17,-15]]
// 29
// 53
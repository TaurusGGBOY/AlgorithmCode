import java.util.Comparator;
import java.util.Vector;

class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1)
            return intervals;
        Vector<Vector<Integer>> vectors = new Vector<>();

        for (int i = 0; i < intervals.length; i++) {
            Vector<Integer> vector = new Vector<>();
            vector.add(intervals[i][0]);
            vector.add(intervals[i][1]);
            vectors.add(vector);
        }
        vectors.sort(new Comparator<Vector<Integer>>() {
            @Override
            public int compare(Vector<Integer> o1, Vector<Integer> o2) {
                if (o1.get(0) != o2.get(0))
                    return o1.get(0) - o2.get(0);
                return o1.get(1) - o2.get(1);
            }
        });
        int left = vectors.get(0).get(0);
        int right = vectors.get(0).get(1);
        Vector<Vector<Integer>> res = new Vector<>();
        for (int i = 1; i < vectors.size(); i++) {
            if (vectors.get(i).get(0) > right) {
                Vector<Integer> vector = new Vector<>();
                vector.add(left);
                vector.add(right);
                res.add(vector);
                left = vectors.get(i).get(0);
                right = vectors.get(i).get(1);
            } else {
                right = Math.max(right, vectors.get(i).get(1));
            }
        }
        Vector<Integer> vector = new Vector<>();
        vector.add(left);
        vector.add(right);
        res.add(vector);
        int[][] resArr = new int[res.size()][2];
        for (int i = 0; i < resArr.length; i++) {
            resArr[i][0] = res.get(i).get(0);
            resArr[i][1] = res.get(i).get(1);
        }
        return resArr;


    }
}
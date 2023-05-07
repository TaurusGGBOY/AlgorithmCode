import java.util.List;

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.size()==0)
            return 0;
        for (int i = triangle.size() - 1; i > 0; i--) {
            for (int j = 0; j < triangle.get(i).size() - 1; j++) {
                try {
                    triangle.get(i - 1).set(j, Math.min(triangle.get(i).get(j), triangle.get(i).get(j + 1)) + triangle.get(i - 1).get(j));
                } catch (Exception e) {
                    triangle.get(i - 1).set(j, triangle.get(i).get(j) + triangle.get(i - 1).get(j));
                }
            }
        }
        int res = triangle.get(0).get(0);
        for(int i=0;i<triangle.get(0).size();i++)
        {
            res = Math.min(res, triangle.get(0).get(i));
        }
        return res;
    }
}
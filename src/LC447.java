// 失败
class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int res = 0;
        for(int[] point1 : points){
            HashMap<Integer,Integer> map = new HashMap<>();
            for(int[] point2 : points){
                if(Arrays.equals(point1, point2)) continue;
                int space = (point1[0] - point2[0]) * (point1[0] - point2[0]) + (point1[1] - point2[1]) * (point1[1] - point2[1]);
                map.put(space,map.getOrDefault(space,0)+1);
            }
            for(int i : map.values()){
                res += i*(i-1);
            }
        }
        return res;
    }
}
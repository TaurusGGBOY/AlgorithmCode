class Solution {
    public int wateringPlants(int[] plants, int capacity) {
        int res = 0;
        int temp = capacity;
        for (int i = 0; i < plants.length; i++) {
            if (temp >= plants[i]) {
                temp -= plants[i];
                res++;
            }else{
                temp = capacity;
                temp-=plants[i];
                res += (i)+(i+1);
            }
//            System.out.println(res);
        }
        return res;
    }
}
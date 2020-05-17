// 失败
class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        //排除两种情况
        Arrays.sort(houses);
        Arrays.sort(heaters);
        if (heaters[0] >= houses[houses.length - 1]) {
            return heaters[0] - houses[0];
        }
        if (heaters[heaters.length - 1] <= houses[0]) {
            return houses[houses.length - 1] - heaters[heaters.length - 1];
        }

        int radius = 0;
        int i=0;
        int j = 0;
        if (houses[0] < heaters[0]) {
            radius = heaters[0] - houses[0];
        }
        while (houses[i] <= heaters[j]) {
            i++;
        }
        while (j < heaters.length - 1&&i<houses.length) {
            if (houses[i] <= heaters[j+1]) {
                radius = Math.max(radius, Math.min(houses[i]-heaters[j], heaters[j + 1] - houses[i]));
                i++;
            }else{
                j++;
            }
        }
        if (i < houses.length) {
            radius = Math.max(radius, houses[houses.length - 1] - heaters[heaters.length - 1]);
        }

        return radius;
    }
}
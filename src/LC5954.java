class Solution {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int l=0;
        int r = plants.length - 1;
        int ra = capacityA;
        int rb = capacityB;
        int res=0;
        while (l <= r) {
            if (l == r) {
                int max = Math.max(ra, rb);
                if (max < plants[l]) {
                    res++;
                    break;
                }else{
                    break;
                }
            }
            if (ra < plants[l]) {
                ra = capacityA;
                res++;
            }
            ra -= plants[l];
            if (rb < plants[r]) {
                rb = capacityB;
                res++;
            }
            rb -= plants[r];
            l++;
            r--;
        }
        return res;
    }
}
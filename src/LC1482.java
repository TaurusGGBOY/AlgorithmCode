class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if (bloomDay.length < m * k) {
            return -1;
        }

        int minDay = 1;
        int maxDay = 1000000000;
        int day = (minDay + maxDay) / 2;
        int res = maxDay;
        while (minDay < maxDay) {
            if (canFinish(bloomDay, m, k, day)) {
                res = Math.min(day, res);
                maxDay = day - 1;
            } else {
                minDay = day + 1;
            }
            day = (maxDay + minDay) / 2;
        }
        if (canFinish(bloomDay, m, k, day)) {
            res = day;
        }
        return res;
    }

    public boolean canFinish(int[] bloomDay, int m, int k, int day) {
        int flower = 0;
        int state = 0;
        for (int bloom : bloomDay) {
            if (bloom <= day) {
                state++;
                if (state >= k) {
                    flower++;
                    state = 0;
                }
            } else {
                state = 0;
            }
        }
        return flower >= m;
    }
}
class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        if (hour < dist.length - 1) {
            return -1;
        }
        int left = 1;
        int right = 10000000;
        int mid = (left + right) / 2;
        double[] record = new double[10000001];
        while (left < right) {
            double time = 0;
            for (int i = 0; i < dist.length - 1; i++) {
                int temp = dist[i];
                time += Math.ceil((temp * 1.0f) / (mid * 1.0f));
            }
            time += (dist[dist.length - 1] * 1.0f) / (mid * 1.0f);
            record[mid] = time;
            if (time < hour) {
                right = mid - 1;
            } else if (time > hour) {
                left = mid + 1;
            } else {
                return mid;
            }
            mid = (left + right) / 2;
        }
        if (record[mid] == 0) {
            double time = 0;
            for (int i = 0; i < dist.length - 1; i++) {
                int temp = dist[i];
                time += Math.ceil((temp * 1.0f) / (mid * 1.0f));
            }
            time += (dist[dist.length - 1] * 1.0f) / (mid * 1.0f);
            record[mid] = time;
        }

        if (record[mid] > hour) {
            return mid+1;
        }
        return mid;
    }
}
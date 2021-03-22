class Solution {
    public int maxValue(int n, int index, int maxSum) {
        int max = 1;
        // 设置最大值为最大和减去其他都是1
        // 结束条件是 这个值是0或者是n？
        // 应该是左边界=有边界
        int left = 1;
        int right = maxSum - n + 1;
        int mid = (left + right) / 2;
        System.out.println();
        System.out.println();
        while (left <= right) {
            long tempSum = mid;
            System.out.print(mid + " ");
            try {
                // 如果左侧的元素太多 就要填充1
                if (index > mid - 1) {
                    tempSum += (index - mid + 1);
                    System.out.print(tempSum + " ");
                    tempSum += (1 + mid - 1) * (mid - 1) / 2;
                } else {
                    tempSum += (mid - 1 + mid - index) * index / 2;
                }
                System.out.print(tempSum + " ");

                if (n - index - 1 > mid - 1) {
                    tempSum += ((n - index - 1) - (mid - 1));
                    System.out.print(tempSum + " ");
                    tempSum += (1 + mid - 1) * (mid - 1) / 2;

                } else {
                    tempSum += (mid - 1 + mid - (n - index - 1)) * (n - index - 1) / 2;
                }
                System.out.print(tempSum + " ");
            } catch (Exception e) {
                tempSum = Long.MAX_VALUE / 2;
            }
            // 说明左边界还可以往右
            if (tempSum <= maxSum) {
                max = Math.max(max, mid);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
            mid = (left + right) / 2;
            System.out.println();

        }
        System.out.println();
        System.out.println();
        System.out.println();

        return max;
    }
}
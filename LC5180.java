import java.util.*;

// 失败
class Solution {
    int pos;
    int start;
    int end;
    int kNum;

    public int constrainedSubsetSum(int[] nums, int k) {
        Vector<Integer> vector = new Vector<>();
        int sum = 0;
        int maxSum = 0;
        int hasZheng = 0;
        int max = Integer.MIN_VALUE;
        int pos = 0;
        while (pos < nums.length && nums[pos] <= 0) {
            max = Math.max(nums[pos], max);
            pos++;
        }
        ;
        for (int i = pos; i < nums.length; i++) {
            if (nums[i] < 0) {
                {
                    vector.add(nums[i]);
                }
            } else {
                hasZheng = 1;
                if (!vector.isEmpty()) {
                    if (vector.size() > k - 1) {
                        vector.sort(new Comparator<Integer>() {
                            @Override
                            public int compare(Integer o1, Integer o2) {
                                return o1 - o2;
                            }
                        });
//                        System.out.println(vector.toString());
//                        System.out.println(sum);
                        for (int j = 0; j < vector.size() - k + 1; j++) {
                            sum += vector.get(vector.size() - 1 - j);
                        }
//                        System.out.println(sum);

                    }
                }
                vector.clear();
                if (sum < 0)
                    sum = nums[i];
                else
                    sum += nums[i];

//                System.out.println("第" + i + " " + String.valueOf(sum));
                maxSum = Math.max(sum, maxSum);
            }
        }
        if (hasZheng == 0)
            return max;
        return sum;

    }
}
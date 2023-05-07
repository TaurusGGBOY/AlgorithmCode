import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    public int[] recoverArray(int[] nums) {
        Arrays.sort(nums);
        List<Integer> recover = recover(0, nums);
        System.out.println();
        return recover.stream().mapToInt(i -> i).toArray();
    }

    List<Integer> recover(int pos, int[] nums) {
        if (pos >= nums.length) {
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>();
        int len = 0;
        for (; pos + len + len + 1 < nums.length; len++) {
            if (check(pos, nums, len)) {
                break;
            }
        }
        System.out.println(pos + " " + len);
        for (int i = pos; i <= pos + len; i++) {
            list.add((nums[i] + nums[i + len + 1]) / 2);
        }
        list.addAll(recover(pos + len + len + 2, nums));
        return list;
    }

    boolean check(int pos, int[] nums, int len) {
        int dis = nums[pos + len + 1] - nums[pos];
        if (dis < 1) {
            return false;
        }
        for (int i = 1; i < len; i++) {
            if (nums[pos + i + len + 1] - nums[pos + i] != dis) {
                return false;
            }
        }
        return true;
    }
}

//[2,10,6,4,8,12]
//[1,1,3,3]
//[5,435]
//[1,1,2,3,3,4]
//[1,1,3,3,8,16]
//[1,1,3,3,8,16, 20, 28]
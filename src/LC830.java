import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        char[] cstr = S.toCharArray();

        int count = 1; // 两个=1
        char c = cstr[0];
        for (int i = 1; i < cstr.length; i++) {
            if (c == cstr[i]) {
                count++;
            } else {
                if (count < 3) {
                    count = 1;
                    c = cstr[i];
                } else {
                    list = new ArrayList<>();
                    list.add(i - count);
                    list.add(i - 1);
                    count = 1;
                    c = cstr[i];
                    res.add(list);
                }
            }
        }
        if (count >= 3) {
            list = new ArrayList<>();
            list.add(cstr.length - count);
            list.add(cstr.length - 1);

            res.add(list);
        }
        return res;
    }
}
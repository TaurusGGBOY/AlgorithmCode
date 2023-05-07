import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        int[][] leftRight = new int[26][2];
        for (int i = 0; i < 26; i++) {
            leftRight[i][0] = s.indexOf(i + 'a');
            leftRight[i][1] = s.lastIndexOf(i + 'a');

        }
        ArrayList<int[]> arrayList = new ArrayList<>();
        for (int[] ints : leftRight) {
            if (ints[0] != -1)
                arrayList.add(ints);
        }
        List<String> res = new ArrayList<>();
        while (!arrayList.isEmpty()) {
            int[] temp = arrayList.get(0);
            int size = arrayList.size();
            for (int i = 1; i < arrayList.size(); i++) {
                if (temp[0] >= arrayList.get(i)[0] && temp[0] <= arrayList.get(i)[1]) {
                    arrayList.remove(i);
                    arrayList.remove(0);
                    break;
                } else if (temp[1] >= arrayList.get(i)[0] && temp[1] <= arrayList.get(i)[1]) {
                    arrayList.remove(i);
                    arrayList.remove(0);
                    break;
                }
            }
            if (size == arrayList.size()) {
                res.add(s.substring(temp[0], temp[1] + 1));
                arrayList.remove(0);
            }

        }
        return res;
    }
}
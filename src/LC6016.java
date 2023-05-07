import java.util.*;

class Solution {
    public List<String> cellsInRange(String s) {
        String[] split = s.split(":");
        int column = split[1].charAt(0) - split[0].charAt(0);
        int row = split[1].charAt(1) - split[0].charAt(1);
        List<String> res = new ArrayList<>();
        for (int j = 0; j <= column; j++) {
            for (int i = 0; i <= row; i++) {
                res.add((char) (split[0].charAt(0) + j) + "" + (char) (split[0].charAt(1) + i));
            }
        }
        return res;
    }
}
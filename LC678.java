class Solution {
    public boolean checkValidString(String s) {
        int[] minMaxLeft = new int[2];
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c == '(') {
                minMaxLeft[0]++;
                minMaxLeft[1]++;
            } else if (c == ')') {
                minMaxLeft[0] = Math.max(minMaxLeft[0]-1, 0);
                minMaxLeft[1]--;
                if (minMaxLeft[1] < 0) {
                    return false;
                }
            }else{
                minMaxLeft[0] = Math.max(minMaxLeft[0]-1, 0);
                minMaxLeft[1]++;
            }
        }
        return minMaxLeft[0] == 0;
    }
}
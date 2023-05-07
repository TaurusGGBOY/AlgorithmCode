// TODO: 失败
class Solution {
    public int minFlips(String target) {
        int res = 0;
        boolean hasOneHere = false;
        for (char c : target.toCharArray()) {
            if (c == '0' && hasOneHere) {
                res++;
                hasOneHere = false;
            } else if (c == '1' && !hasOneHere) {
                res++;
                hasOneHere = true;
            }
        }
        return res;
    }
}
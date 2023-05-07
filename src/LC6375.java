class Solution {
    public int addMinimum(String word) {
        int res = 0;
        int index = 0;
        char[] states = {'a', 'b', 'c'};
        for (char c : word.toCharArray()) {
            while (true) {
                if (c != states[index]) {
                    index = (index + 1) % states.length;
                    res++;
                    continue;
                }
                index = (index + 1) % states.length;
                break;
            }
        }
        if (index == 1) return res + 2;
        if (index == 2) return res + 1;
        return res;
    }
}
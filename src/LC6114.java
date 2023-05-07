class Solution {
    public boolean canChange(String start, String target) {
        int l1 = 0, r1 = start.length() - 1, l2 = 0, r2 = target.length() - 1;
        int[] count = new int[4];
        while (l1 <= r1 && l2 <= r2) {
            while (l1 <= r1 && start.charAt(l1) == '_') l1++;
            while (l2 <= r2 && target.charAt(l2) == '_') l2++;
            if(l1 <= r1 && start.charAt(l1) == 'L') count[0]++;
            if(l1 <= r1 && start.charAt(l1) == 'R') count[1]++;
            if(l2 <= r2 && target.charAt(l2) == 'L') count[2]++;
            if(l2 <= r2 && target.charAt(l2) == 'R') count[3]++;

            if (l1 <= r1 && l2 <= r2 && start.charAt(l1) != target.charAt(l2)) return false;
            if (l1 <= r1 && l2 <= r2 && start.charAt(l1) == 'L' && l1 < l2) return false;
            if (l1 <= r1 && l2 <= r2 && start.charAt(l1) == 'R' && l1 > l2) return false;
            l1++;
            l2++;
        }
        return count[0] == count[2] && count[1] == count[3];
    }
}
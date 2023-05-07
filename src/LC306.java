import java.math.BigInteger;
class Solution {
    public boolean isAdditiveNumber(String num) {
        if (num.length() <= 2) return false;
        int s = 0, l = 1, r = 1;
        while (l < num.length() - 1) {
            if (r++ >= num.length()) r = ++l + 1;
            int start = s, left = l, right = r;
            if (num.charAt(start) == '0' && left - start > 1) continue;
            if (num.charAt(left) == '0' && right - left > 1) continue;
            while (right < num.length()) {
                String prev = num.substring(start, left), next = num.substring(left, right);
                String str = new BigInteger(prev).add(new BigInteger(next)).toString();
                if (right + str.length() > num.length() || !num.startsWith(str, right)) break;
                start = left;
                left = right;
                right = right + str.length();
                if (right == num.length()) return true;
            }
        }
        return false;
    }
}

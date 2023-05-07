class Solution {
    public String largestGoodInteger(String num) {
        int res = -1;
        for (int i = 0; i < num.length()-2; i++) {
            if (num.charAt(i)==num.charAt(i+1) && num.charAt(i+1) == num.charAt(i+2)) {
                res = Math.max(num.charAt(i) - '0', res);
            }
        }
        if(res < 0) return "";
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            stringBuilder.append(res);
        }
        return stringBuilder.toString();
    }
}
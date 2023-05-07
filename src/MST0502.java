class Solution {
    public String printBin(double num) {
        double base = 0.5f;
        StringBuilder stringBuilder = new StringBuilder("0.");
        for (int i = 0; i < 30; i++) {
            if (num >= base) {
                num -= base;
                stringBuilder.append("1");
            } else {
                stringBuilder.append("0");
            }
            base *= 0.5f;
            if (num == 0) return stringBuilder.toString();
        }
        return "ERROR";
    }
}
class Solution {
    public int reverse(int x) {
        StringBuilder stringBuilder = new StringBuilder();
        String str = String.valueOf(x);
        if (str.startsWith("-")) {
            stringBuilder.append(str.substring(1));
        }else {
            stringBuilder.append(str);
        }
        stringBuilder.reverse();
        if (str.startsWith("-")) {
            stringBuilder.insert(0, "-");
        }
        try {
            int temp = Integer.parseInt(stringBuilder.toString());
            return Integer.parseInt(stringBuilder.toString());
        } catch (Exception e) {
            return 0;
        }

    }
}
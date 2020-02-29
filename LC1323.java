class Solution {
    public int maximum69Number(int num) {
        String numString = String.valueOf(num);
        StringBuilder stringBuilder = new StringBuilder(numString);
        for (int i = 0; i < numString.length(); i++) {
            if (numString.charAt(i) == '6') {
                stringBuilder.setCharAt(i, '9');
                return Integer.parseInt(stringBuilder.toString());
            }
        }

        return num;

    }
}
class Solution {
    public boolean isSameAfterReversals(int num) {
        int re = reverse(num);
        int re2 = reverse(re);
        return num == re2;
    }

    int reverse(int num) {
        String str = String.valueOf(num);
        StringBuilder stringBuilder = new StringBuilder(str);
        stringBuilder.reverse();
//        System.out.println(stringBuilder.toString());
        return Integer.parseInt(stringBuilder.toString());
    }
}
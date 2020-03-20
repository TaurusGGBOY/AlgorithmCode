class Solution {
    public int bitwiseComplement(int N) {
        String Nstr = Integer.toBinaryString(N);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < Nstr.length(); i++) {
            stringBuilder.append(Nstr.charAt(i)=='1'?'0':'1');
        }
        return Integer.parseInt(stringBuilder.toString(), 2);

    }
}
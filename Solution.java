class Solution {
    public int insertBits(int N, int M, int i, int j) {
        String Nstr = Integer.toBinaryString(N);
        String Mstr = Integer.toBinaryString(M);
        char[] Ncstr = Nstr.toCharArray();
        char[] Mcstr = Mstr.toCharArray();
        for(int k=j;k>=i;k--)
        {
            Ncstr[k]=Mcstr[k-i];
        }
        return Integer.parseInt(String.valueOf(Ncstr), 2);
    }
}
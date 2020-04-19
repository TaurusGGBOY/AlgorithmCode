class Solution {
    public String licenseKeyFormatting(String S, int K) {
        char[] chars = S.toUpperCase().toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : chars) {
            if (c != '-')
                stringBuilder.append(c);
        }
        S = stringBuilder.toString();
        if (S.length() < K)
            return S;
        int count = S.length() / K;
        int first = S.length() - count * K;
        if (first == 0) {
            first = K;
            count--;
        }
//        System.out.println(S);
        StringBuilder res = new StringBuilder();
        for(int i=0;i<first;i++)
        {
            res.append(stringBuilder.charAt(i));
        }
        for(int i=0;i<count;i++)
        {
            res.append('-');
            for(int j=0;j<K;j++)
            {
                res.append(stringBuilder.charAt(first+i*K+j));
            }
        }
        return res.toString();

    }
}
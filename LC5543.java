class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int[] first = new int[26];
        int[] last = new int[26];

        for (int i = 0; i < first.length; i++) {
            first[i] = s.indexOf((char)('a'+i));
        }
        for (int i = 0; i < last.length; i++) {
            last[i] = s.lastIndexOf((char) ('a' + i));
        }
        int max =-1;
        for (int i = 0; i < first.length; i++) {
            if(first[i]==-1)
                continue;
            int temp = last[i] - first[i];
            if(temp>max)
            {
                max=temp;
            }
        }
        return max-1;

    }
}
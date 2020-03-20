class Solution {
    public int binaryGap(int N) {
        String NStr = Integer.toBinaryString(N);
        int maxLen=0;
        int lastPos =(int) (NStr.length()-Math.log(Integer.highestOneBit(N)) / Math.log(2)-1);
        //System.out.println(lastPos);
        if(lastPos==-1)
            return 0;
        //System.out.println(NStr);
        for (int i = lastPos; i < NStr.length(); i++) {
            if(NStr.charAt(i)=='1')
            {
                maxLen = Math.max(maxLen, i - lastPos);
                lastPos=i;
            }
        }
        return maxLen;
    }
}
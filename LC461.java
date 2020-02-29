class Solution {
    public int hammingDistance(int x, int y) {
        String xString = Integer.toBinaryString(x);
        String yString = Integer.toBinaryString(y);

        StringBuilder xStringBuilder = new StringBuilder();
        StringBuilder yStringBuilder = new StringBuilder();

        int lenDis = xString.length() - yString.length();

        if (lenDis > 0)
            for (int i = 0; i < lenDis; i++)
                yStringBuilder.append("0");
        else
            for (int i = 0; i < -lenDis; i++)
                xStringBuilder.append("0");

        xStringBuilder.append(xString);
        yStringBuilder.append(yString);

        int count = 0;
        for (int i = 0; i < xStringBuilder.length(); i++)
            if (xStringBuilder.charAt(i) != yStringBuilder.charAt(i))
                count++;
        return count;

    }
}
class Solution {
    public String largestTimeFromDigits(int[] A) {

    }

    boolean isValid(String s)
    {
        if(s.charAt(0)-'0'>2)
            return false;
        if(s.charAt(2)-'0'>6)
            return false;
        return true;
    }

    int getTime(String s)
    {
        String[] strings = s.split(":");
        return Integer.parseInt(strings[0])*60+Integer.parseInt(strings[1]);
    }
}
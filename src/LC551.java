class Solution {
    public boolean checkRecord(String s) {
        if(s.contains("LLL"))
            return false;
        int index = s.indexOf('A');
        if(index==-1||index==s.length()-1)
            return true;
        return !s.substring(index+1).contains("A");
    }
}
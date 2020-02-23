class Solution {
    public String replaceSpaces(String S, int length) {
        return S.substring(0,length).replaceAll(" ", "%20");
    }
}
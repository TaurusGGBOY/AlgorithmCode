class Solution {
    public boolean checkString(String s) {
        if (!s.contains("b")) {
            return true;
        }
        return s.lastIndexOf("a") < s.indexOf("b");
    }
}
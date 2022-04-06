class Solution {
    public boolean isNumber(String s) {
        s = s.trim();
        if (s.isEmpty()) return false;
        while (s.startsWith(" ")) s = s.substring(1);
        s = s.toLowerCase();
        if (s.startsWith("e") || s.endsWith("e")) return false;
        if (!s.contains("e")) return isFloat(s);
        String[] strs = s.split("e");
        if (strs.length != 2) return false;
        return isFloat(strs[0]) && isInteger(strs[1]);
    }

    boolean isFloat(String s) {
        try {
            Double.parseDouble(s);
        } catch (Exception e) {
            return false;
        }
        return !s.contains("d") && !s.contains("f") && !s.contains(" ") && !s.equals(".") && (s.indexOf('.') == s.lastIndexOf('.'));
    }

    boolean isInteger(String s) {
        try {
            Long.parseLong(s);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}

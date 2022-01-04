class Solution {
    public String validIPAddress(String IP) {
        if (IP.startsWith(".") || IP.endsWith(".")||IP.startsWith(":") || IP.endsWith(":")) {
            return "Neither";
        }
        String[] strs = IP.split("[.:]");
        if (strs.length == 4) {
            boolean b1 = validV4(strs);
            if (b1) return "IPv4";
        }
        if (strs.length == 8) {
            boolean b2 = validV6(strs);
            if (b2) return "IPv6";
        }

        return "Neither";
    }

    boolean validV4(String[] strs) {
        for (String s : strs) {
            if (s.startsWith("0") && !s.equals("0")) {
                return false;
            }
            int num = 0;
            try {
                num = Integer.parseInt(s);
            } catch (Exception e) {
                return false;
            }
            if (num > 255 || num < 0) {
                return false;
            }
        }
        return true;
    }

    boolean validV6(String[] strs) {
        int bound = Integer.parseInt("FFFF", 16);
        for (String s : strs) {
            if (s.length() > 4) {
                return false;
            }
            int num = 0;
            try {
                 num = Integer.parseInt(s, 16);
            } catch (Exception e) {
                return false;
            }
            if (num > bound || num < 0) {
                return false;
            }
        }
        return true;
    }
}
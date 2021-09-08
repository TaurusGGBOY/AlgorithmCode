class Solution {
    public int compareVersion(String version1, String version2) {

        String[] split1 = version1.split("\\.");
        String[] split2 = version2.split("\\.");
        for (int i = 0; i < split1.length && i < split2.length; i++) {
            int i1 = Integer.parseInt(split1[i]);
            int i2 = Integer.parseInt(split2[i]);
            if (i1 > i2) {
                return 1;
            } else if (i1 < i2) {
                return -1;
            }
        }
        for (int i = Math.min(split1.length, split2.length); i < split1.length || i < split2.length; i++) {
            try {
                int i1 = Integer.parseInt(split1[i]);
                if (i1!=0) {
                    return 1;
                }
            } catch (Exception e) {

            }
            try {
                int i2 = Integer.parseInt(split2[i]);
                if (i2 != 0) {
                    return -1;
                }
            } catch (Exception e) {

            }
        }
        return 0;
    }
}
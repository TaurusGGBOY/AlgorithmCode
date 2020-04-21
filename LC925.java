class Solution {
    public boolean isLongPressedName(String name, String typed) {
        char[] cName = name.toCharArray();
        char[] cTyped = typed.toCharArray();

        int i = 0;
        int j = 0;
        char lasti =cName[0];
        while (j != cTyped.length) {
            if (cName[i] == cTyped[j]) {
                lasti=cName[i];
                i++;
                j++;
            } else if(lasti==cTyped[j]){
                j++;
            }
            else
            {
                return false;
            }
            if(i>=cName.length)
                i=cName.length-1;
        }
        if (i < cName.length - 1)
            return false;
        return cName[cName.length - 1] == cTyped[cTyped.length - 1];
    }
}
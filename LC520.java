class Solution {
    public boolean detectCapitalUse(String word) {
        if (word.length() <= 1) {
            return true;
        }
        char[] chars = word.toCharArray();
        if (!isGreat(chars[0])) {
            for (int i = 1;i<chars.length;i++) {
                if(isGreat(chars[i])){
                    return false;
                }
            }
        }else{
            if (isGreat(chars[1])) {
                for (int i = 2;i<chars.length;i++) {
                    if(!isGreat(chars[i])){
                        return false;
                    }
                }
            }else{
                for (int i = 2;i<chars.length;i++) {
                    if(isGreat(chars[i])){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    boolean isGreat(char c){
        return c>='A'&&c<='Z';
    }
}
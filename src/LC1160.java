class Solution {
    public int countCharacters(String[] words, String chars) {
        int[] alpha = new int[26];
        int result=0;
        for (int i = 0; i < chars.length(); i++) {
            alpha[chars.charAt(i)-'a']++;
        }
        int[] temp;
        int flag=0;
        for (String str : words) {
            temp = new int[26];
            System.arraycopy(alpha, 0, temp, 0, 26);
            flag=1;
            for (int i = 0; i < str.length(); i++) {
                temp[str.charAt(i)-'a']--;
                if(temp[str.charAt(i)-'a']<0)
                {
                    flag = 0;
                    break;
                }
            }
            if (flag == 1) {
                result += str.length();
            }

        }
        return result;
    }
}
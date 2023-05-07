class Solution {
    public String freqAlphabets(String s) {
        String[] strings = s.split("#");
        StringBuilder stringBuilder = new StringBuilder();
        if (s.endsWith("#")) {
            for (String string : strings) {
                for (int i = 0; i < string.length() - 2; i++) {
                    stringBuilder.append((char) (string.charAt(i) - '0' + 'a' - 1));
                }
                stringBuilder.append((char) (Integer.parseInt(string.substring(string.length() - 2)) + 'a' - 1));
            }
        } else {
            for (int k = 0; k < strings.length - 1; k++) {
                String string = strings[k];
                for (int i = 0; i < string.length() - 2; i++) {
                    stringBuilder.append((char) (string.charAt(i) - '0' + 'a' - 1));
                }
                stringBuilder.append((char) (Integer.parseInt(string.substring(string.length() - 2)) + 'a' - 1));
            }
            for (int i = 0; i < strings[strings.length - 1].length(); i++) {
                stringBuilder.append((char) (strings[strings.length - 1].charAt(i) - '0' + 'a' - 1));
            }

        }
        return stringBuilder.toString();
    }
}
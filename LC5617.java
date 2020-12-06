class Solution {
    public String interpret(String command) {
        int pos = 0;
        StringBuilder stringBuilder = new StringBuilder();
        while (pos < command.length()) {
            String temp = command.substring(pos);
            if (temp.startsWith("()")) {
                stringBuilder.append("o");
                pos += 2;
            } else if (temp.startsWith("G")) {
                stringBuilder.append("G");
                pos++;
            } else {
                stringBuilder.append("al");
                pos += 4;
            }
        }
        return stringBuilder.toString();
    }
}
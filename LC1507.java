class Solution {
    public String reformatDate(String date) {
        String[] strings = date.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(strings[2]);
        stringBuilder.append("-");
        String[] mons = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        int count = 1;
        for (String mon : mons) {
            if (mon.equals(strings[1])) {
                if (count < 10) {
                    stringBuilder.append(0);
                    stringBuilder.append(count);
                } else {
                    stringBuilder.append(count);
                }
                break;
            }
            count++;
        }
        stringBuilder.append("-");
        if (strings[0].length() == 4) {
            stringBuilder.append(strings[0].substring(0, 2));
        } else {
            stringBuilder.append(0);
            stringBuilder.append(strings[0].charAt(0));
        }
        return stringBuilder.toString();
    }
}
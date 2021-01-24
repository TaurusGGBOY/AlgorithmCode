class Solution {
    public String maximumTime(String time) {
        String[] split = time.split(":");
        char[] hour = split[0].toCharArray();
        char[] min = split[1].toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        if (hour[0] == '?' && hour[1] == '?') {
            hour[0] = '2';
            hour[1] = '3';
        } else if (hour[0] == '?') {
            if (hour[1] < '4') {
                hour[0] = '2';
            } else {
                hour[0] = '1';
            }
        } else if(hour[1]=='?'){
            if (hour[0] == '2') {
                hour[1] = '3';
            } else {
                hour[1] = '9';
            }
        }
        stringBuilder.append(hour[0]);
        stringBuilder.append(hour[1]);
        stringBuilder.append(":");
        if (min[0] == '?' && min[1] == '?') {
            min[0] = '5';
            min[1] = '9';
        } else if (min[0] == '?') {
            min[0] = '5';
        } else if(min[1]=='?'){
            min[1] = '9';
        }
        stringBuilder.append(min[0]);
        stringBuilder.append(min[1]);

        return stringBuilder.toString();
    }

    public boolean isLegal(String time) {
        String[] strings = time.split(":");
        int hour = Integer.parseInt(strings[0]);
        int min = Integer.parseInt(strings[1]);
        if (hour >= 0 && hour <= 24) {
            if (min >= 0 && min <= 59) {
                return true;
            }
        }
        return false;
    }
}
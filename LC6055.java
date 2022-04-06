class Solution {
    public int convertTime(String current, String correct) {
        String[] strs1 = current.split(":");
        String[] strs2 = correct.split(":");
        int time1 = Integer.parseInt(strs1[0]) * 60 + Integer.parseInt(strs1[1]);
        int time2 = Integer.parseInt(strs2[0]) * 60 + Integer.parseInt(strs2[1]);
        if (time2 < time1) time2 += 24 * 60;
        int dis = time2 - time1;
        int count = 0;
        count += dis / 60;
        dis = dis - (dis / 60) * 60;
        count += dis / 15;
        dis = dis - (dis / 15) * 15;
        count += dis / 5;
        dis = dis - (dis / 5) * 5;
        count += dis;
        return count;
    }
}
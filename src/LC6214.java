class Solution {
    public boolean haveConflict(String[] event1, String[] event2) {
        int time1 = 60 * Integer.parseInt(event1[0].split(":")[0]) + Integer.parseInt(event1[0].split(":")[1]);
        int time2 = 60 * Integer.parseInt(event1[1].split(":")[0]) + Integer.parseInt(event1[1].split(":")[1]);
        int time3 = 60 * Integer.parseInt(event2[0].split(":")[0]) + Integer.parseInt(event2[0].split(":")[1]);
        int time4 = 60 * Integer.parseInt(event2[1].split(":")[0]) + Integer.parseInt(event2[1].split(":")[1]);
        if (time1 >= time3 && time1 <= time4) return true;
        if (time3 >= time1 && time3 <= time2) return true;
        return false;
    }
}
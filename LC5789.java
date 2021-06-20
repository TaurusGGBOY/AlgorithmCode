class Solution {
    public int numberOfRounds(String startTime, String finishTime) {
        String[] startS = startTime.split(":");
        String[] finishS = finishTime.split(":");
        int start = Integer.parseInt(startS[0]) * 60 + Integer.parseInt(startS[1]);
        int finish = Integer.parseInt(finishS[0]) * 60 + Integer.parseInt(finishS[1]);

        if (finish <= start) {
            finish += 24 * 60;
        }
        start = (int)Math.ceil(start*1.0f/15)*15;
        finish = (finish / 15) * 15;
//        System.out.println(start + " " + finish);
        int dis = finish - start;
        return dis / 15;
    }
}
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

class Solution {
    public int daysBetweenDates(String date1, String date2) {

        try {
            Date datea1 = new SimpleDateFormat("yyyy-MM-dd").parse(date1);
            Date datea2 = new SimpleDateFormat("yyyy-MM-dd").parse(date2);
            long datelong = 60*60*24*1000;
            return Math.abs((int)((datea1.getTime()-datea2.getTime())/datelong));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;



    }
}
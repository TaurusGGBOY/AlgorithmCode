import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

class Solution {
    public int dayOfYear(String date) {
        try {
            Calendar ca = Calendar.getInstance();
            ca.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(date));
            return ca.get(Calendar.DAY_OF_YEAR);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }
}e
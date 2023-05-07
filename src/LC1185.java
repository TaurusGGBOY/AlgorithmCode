import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

class Solution {
  public String dayOfTheWeek(int day, int month, int year) {
    String[] weekDays = {
      "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"
    };
    Calendar cal = Calendar.getInstance();
    try {

      cal.setTime(
          new SimpleDateFormat("yyyy-MM-dd")
              .parse(
                  String.valueOf(year) + "-" + String.valueOf(month) + "-" + String.valueOf(day)));

    } catch (Exception e) {
    }
    int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
    if (w < 0) w = 0;
    return weekDays[w];
  }
}

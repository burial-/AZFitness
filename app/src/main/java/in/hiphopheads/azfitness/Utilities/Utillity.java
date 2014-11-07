package in.hiphopheads.azfitness.Utilities;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

/**
 * Created on 7/11/14.
 */
public class Utillity {

    // This is a plethora of code that just converts the date to a readable format
    // (2014-01-18 = Tuesday, the 1st of January, 2014)
    public String formatDate(Date date) throws ParseException {
        java.text.SimpleDateFormat simpleDateFormatForParse = new java.text.SimpleDateFormat("yyyy-mm-dd");
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        Date currentDate = cal.getTime();
        java.text.SimpleDateFormat simpleDateFormatForDay = new java.text.SimpleDateFormat("d");
        java.text.SimpleDateFormat simpleDateFormatForDayName = new java.text.SimpleDateFormat("EEEE");
        String dayName = simpleDateFormatForDayName.format(currentDate);
        Integer day = Integer.parseInt(simpleDateFormatForDay.format(currentDate));
        java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat("MMMM, yyyy");
        return dayName +", " +day + getDayOfMonthSuffix(day) + " "  + simpleDateFormat.format(currentDate);
    }

    // Because someone overlooked the idea that you would want a day of month suffix in the
    // SimpleDateFormat utility we have this here.
    String getDayOfMonthSuffix(final int n) {
        if (n >= 11 && n <= 13) {
            return "th";
        }
        switch (n % 10) {
            case 1:
                return "st";
            case 2:
                return "nd";
            case 3:
                return "rd";
            default:
                return "th";
        }
    }
}

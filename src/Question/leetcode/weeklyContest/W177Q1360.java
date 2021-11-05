package Question.leetcode.weeklyContest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

/**
 * Created by gump on 2020/2/23.
 */
public class W177Q1360 {

    public static void main(String args[]) throws ParseException {
        W177Q1360 q = new W177Q1360();
        String date1 = "1971-06-29", date2 = "2010-09-23";


        System.out.println(q.daysBetweenDates(date1,date2));
    }


    public int daysBetweenDates(String date1, String date2)  {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date d1 = null;
        try {
            d1 = simpleDateFormat.parse(date1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date d2 = null;
        try {
            d2 = simpleDateFormat.parse(date2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Instant instant1 = d1.toInstant();
        Instant instant2 = d2.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDate localDate1 = instant1.atZone(zoneId).toLocalDate();
        LocalDate localDate2 = instant2.atZone(zoneId).toLocalDate();


        return Period.between(localDate2,localDate1).getDays();
    }
}

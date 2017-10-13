package Question.interview.perfectWorld;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by gump on 2017/9/26.
 */
public class Q1 {
    public static void main(String argc[]){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String time1 = sc.nextLine();
            String time2 = sc.nextLine();
            String temp[] = time1.split(" ");
            

            String temp2[] = time2.split(" ");
            String temp2T[] = temp2[1].split(":");
            int h2 = Integer.parseInt(temp2T[0]);
            int m2 = Integer.parseInt(temp2T[1]);
            int s2 = Integer.parseInt(temp2T[2]);

            SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
            try {
                Date begin = format.parse(temp[0]);
                Date end = format.parse(temp2[0]);

                long zero = (end.getTime()-begin.getTime())/(24*60*60*1000)-1;
                long thur = 0;

                if (h2>0 || m2>0 ||s2>0){
                    zero ++;
                }

                Calendar cal = Calendar.getInstance();
                cal.setTime(begin);
                if (cal.get(Calendar.DAY_OF_WEEK) - 1 == 4){
                    thur ++;
                }

                cal.setTime(end);
                if (cal.get(Calendar.DAY_OF_WEEK) - 1 == 4 && (h2>0 || m2>0 ||s2>0)){
                    thur ++;
                }

                begin = new Date(begin.getTime()+24*60*60*1000);
                end = new Date(end.getTime()-24*60*60*1000);
                while (begin.before(end)){
                    cal.setTime(begin);
                    if (cal.get(Calendar.DAY_OF_WEEK) - 1 == 4){
                        thur ++;
                    }
                    begin = new Date(begin.getTime()+24*60*60*1000);
                }

                System.out.println(zero+","+thur);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }
}

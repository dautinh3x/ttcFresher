package dateExample;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class Main {
    public static void main(String[] args) throws ParseException {
        String string = "2019/11/22 09:22:40";
        String string1 = "2019/11/20 02:31:25";
        DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        DateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        DateFormat formatter2 = new SimpleDateFormat("MMM yyyy,dd HH:mm:ss");
        Date a = formatter.parse(string);
        System.out.println("Convert to java Date: " + a);
        Date b = formatter.parse(string1);
        System.out.println("Compare a > b: " + b.before(a));
        Date c = formatter.parse(string);
        String formattedDate = formatter1.format(c);
        System.out.println("Date format yyyy-MM-dd HH:mm:ss: " + formattedDate);
        Date d = formatter.parse(string);
        String formattedDate1 = formatter2.format(c);
        System.out.println("Date format MMM yyyy,dd HH:mm:ss: " + formattedDate1);

        // chuyển Date sang Timestamp
        Timestamp timestamp = new Timestamp(a.getTime());
        System.out.println("Date to Timestamp: " + timestamp);

        // chuyển Timestamp sang Date
        Date last = new Date(timestamp.getTime());
        System.out.println("Timestamp to Date: " + last);

        System.out.println("Start point: " + timestamp.toString());
        System.out.println("Nearest whole minute: " + toNearestWholeMinute(timestamp));
        System.out.println("Nearest whole hour: " + toNearestWholeHour(timestamp));
        System.out.println("Nearest whole day: " + toNearestWholeDay(timestamp));

        int month = a.getMonth() + 1;
        int year = a.getYear() + 1900;
        System.out.println("Month " + month + " Year " + year + " có:");
        System.out.println("Min day = " + minDay(month, year));
        System.out.println("Max day = " + maxDay(month, year));

        System.out.println((a.getTime() - b.getTime()) / (24 * 60 * 60 * 1000));

    }

    public static Date toNearestWholeMinute(Date d) {
        Calendar c = new GregorianCalendar();
        c.setTime(d);

        if (c.get(Calendar.SECOND) >= 30)
            c.add(Calendar.MINUTE, 1);

        c.set(Calendar.SECOND, 0);

        return c.getTime();
    }

    public static Date toNearestWholeHour(Date d) {
        Calendar c = new GregorianCalendar();
        c.setTime(d);

        if (c.get(Calendar.MINUTE) >= 30)
            c.add(Calendar.HOUR, 1);

        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);

        return c.getTime();
    }

    public static Date toNearestWholeDay(Date d) {
        Calendar c = new GregorianCalendar();
        c.setTime(d);

        if (c.get(Calendar.HOUR) >= 12) {
            c.set(Calendar.HOUR, 0);
            c.set(Calendar.MINUTE, 0);
            c.set(Calendar.SECOND, 0);
            c.add(Calendar.DAY_OF_MONTH, 1);
        }

        return c.getTime();
    }


    public static int minDay(int month, int year) {
        Calendar cal = Calendar.getInstance();
        int minDay = cal.getActualMinimum(Calendar.DAY_OF_MONTH);
        return minDay;
    }

    public static int maxDay(int month, int year) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.MONTH, month - 1);
        cal.set(Calendar.DAY_OF_MONTH, month - 1);
        cal.set(Calendar.YEAR, year);
        int maxDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        return maxDay;
    }

}

package UtilsDemo;

import java.util.Calendar;
import java.util.Date;

/**
 * @Author : LiuYan
 * @create 2021/2/4 10:36
 */
public class DateTest {
    public static void main(String[] args) {
        Date d =  new Date();
        System.out.println(d); // Thu Feb 04 11:06:09 CST 2021
        System.out.println(DateUtils.addDay(d,20)); // Wed Feb 24 11:06:09 CST 2021
        System.out.println(DateUtils.countDays("2021-02-03 11:06:09"));
        System.out.println(DateUtils.countDays("2021-02-03","yyyy-MM-dd"));
        System.out.println(DateUtils.date2Str(new Date())); // 2021-02-04 11:19:33
        System.out.println(DateUtils.date2Str(new Date(),"yyyy-MM-dd")); // 2021-02-04
        Calendar c = Calendar.getInstance();
        System.out.println(c.getTime());// Thu Feb 04 11:26:24 CST 2021
        System.out.println(DateUtils.date2Str(c.getTime()));// 2021-02-04 11:26:24
        System.out.println(DateUtils.date2Str(c.getTime(),"yyyy-MM"));// 2021-02

        System.out.println(DateUtils.getCurDateStr());// 2021-2-4 11:28:53
        System.out.println(DateUtils.getCurDateStr("yyyy-MM"));// 2021-02
        System.out.println(DateUtils.getDatePattern()); //yyyy-MM-dd HH:mm:ss

        Date d1 =  new Date(); //Thu Feb 04 11:53:36 CST 2021
        System.out.println(DateUtils.getDay(d1)); // 4
        System.out.println(d1.getTime()); //1612410816115
        System.out.println(DateUtils.getDay(d1.getTime())); // 2021-02-04
        System.out.println(DateUtils.getMonth(d1)); // 2
        System.out.println(DateUtils.getHour(d1) + ":"+ DateUtils.getMinute(d1) +":"+DateUtils.getSecond(d1)); // 11:53:36
        //2021-02-04 11:53:36
        //2021-02-04 11:53:36.115
        System.out.println(DateUtils.getMillon(d1.getTime())+"\n"+
                DateUtils.getSMillon(d1.getTime()));
        System.out.println(DateUtils.getMillis(d1)); //1612410816115

        System.out.println(DateUtils.getTimeString());//2021-02-04 11:53:36.116
        System.out.println(DateUtils.getNextHour("yyyy-MM-dd HH:mm:ss",-2)); // 2021-02-04 09:53:36

        System.out.println("----------");
        System.out.println(DateUtils.parse("2021-02-04 10:03:59")); // Thu Feb 04 10:03:59 CST 2021
        System.out.println(DateUtils.parse("2021-02-04","yyyy-MM-dd")); // Thu Feb 04 00:00:00 CST 2021
//        System.out.println(DateUtils.parse("")); // 报错

        System.out.println(DateUtils.str2Calendar("2021-02-04 10:08:50").getTime()); // Thu Feb 04 10:08:50 CST 2021
        System.out.println(DateUtils.str2Calendar("2021-02-04 10:08:50","yyyy-MM-dd").getTime());// Thu Feb 04 00:00:00 CST 2021
        System.out.println(DateUtils.str2Date("2021-02-04 10:08:50"));// Thu Feb 04 10:08:50 CST 2021
        System.out.println(DateUtils.str2Date("2021-02-04 10:08:50","yyyy-MM-dd"));// Thu Feb 04 00:00:00 CST 2021
        System.out.println(DateUtils.str2Date("")); // null
    }
}

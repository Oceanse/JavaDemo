package com.demo.basicdemo;

import org.testng.annotations.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class DateDemo {

    @Test
    public void test() {
        //Date 类的无参数构造方法获取的是系统当前的时间，显示的顺序为星期、月、日、小时、分、秒、年
        Date date1 = new Date();
        System.out.println(date1.toString());

        //Date(long date)：此种形式表示从 GMT 时间（格林尼治时间）1970 年 1 月 1 日 0 时 0 分 0 秒开始经过参数 date 指定的毫秒数。
        Date date2 = new Date(3600000);//3600000 ms是一个小时
        System.out.println(date2);//打印出来的是CST时间，GMT（格林尼治标准时间）与 CST（中央标准时间）相差 8 小时

        //返回自 1970 年 1 月 1 日 00:00:00 GMT 以来，此 Date 对象表示的毫秒数
        System.out.println(new Date().getTime());
    }


    /**
     * before: 判断此日期是否在指定日期之前
     * after: 判断此日期是否在指定日期之后
     * equal: 比较两个日期的相等性
     */
    @Test
    public void test2() {
        Date date1 = new Date(3600000);
        Date date2 = new Date(7200000);
        System.out.println(date1.before(date2));

        Date date3 = new Date();
        Date date4 = new Date();
        System.out.println(date3.equals(date4));//在ms精度下， date3等于date4
    }


    /**
     * Calendar 类中定义了许多常量，分别表示不同的意义。
     */
    @Test
    public void test3() {
        Calendar calendar = Calendar.getInstance();// 参数如果不设置时间，则默认为当前时间
        int year = calendar.get(Calendar.YEAR);//年份
        int month = calendar.get(Calendar.MONTH);//月份，如果整型变量 month 的值是 0，表示当前日历是在 1 月份；如果值是 11，则表示当前日历在 12 月份。
        int day = calendar.get(Calendar.DATE);//日期
        int hour_24 = calendar.get(Calendar.HOUR_OF_DAY);//12小时制的小时
        int hour_12 = calendar.get(Calendar.HOUR);//24 小时制的小时
        int minute = calendar.get(Calendar.MINUTE);//分钟
        int second = calendar.get(Calendar.SECOND);//秒
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);//星期几
        System.out.println(year);
        System.out.println(month);
        System.out.println(day);
        System.out.println(hour_12);
        System.out.println(hour_24);
        System.out.println(minute);
        System.out.println(second);
        System.out.println(dayOfWeek);
    }

    /**
     *
     */
    @Test
    public void test4() {
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.getTime());

        //Calendar 类所表示的时间月份是 set() 方法中表示月份的参数值 +1, 实际的calendar对象所表示的日期为2018年9月8日
        calendar.set(2018, 8, 8);//设置年月日，时分秒将默认采用当前值
        System.out.println("设置日期为 2018-8-8 后的时间：" + calendar.getTime()); // 输出时间
    }


    @Test
    public void test5() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2016, 5, 1); // 实际的calendar对象所表示的日期为2016年6月1日
        // 判断2016年6月1日为一周中的第几天
        int index = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        char[] title = {'日', '一', '二', '三', '四', '五', '六'}; // 存放曰历的头部
        int daysArray[][] = new int[6][7];// 存放日历的数据
        int daysInMonth = 31; // 该月的天数
        int day = 1; // 自动增长
        for (int i = index; i < 7; i++) {
            // 填充第一周的日期数据，即日历中的第一行
            daysArray[0][i] = day++;
        }
        for (int i = 1; i < 6; i++) {
            // 填充其他周的日历数据，控制行
            for (int j = 0; j < 7; j++) {
                // 如果当前day表示的是本月最后一天，则停止向数组中继续赋值
                if (day > daysInMonth) {
                    i = 6;
                    break;
                }
                daysArray[i][j] = day++;
            }
        }
        System.out.println("------------------2016 年 6 月--------------------\n");
        for (int i = 0; i < title.length; i++) {
            System.out.print(title[i] + "\t");
        }
        System.out.print("\n");
        // 输出二元数组daysArray中的元素
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                if (daysArray[i][j] == 0) {
                    if (i != 0) {
                        // 如果到月末，则完成显示日历的任务，停止该方法的执行
                        return;
                    }
                    System.out.print("\t");
                    continue;
                }
                System.out.print(daysArray[i][j] + "\t");
            }
            System.out.print("\n");
        }
    }


    /**
     * DateFormat 类中方法与常量的结合使用，通过使用 DateFomat 类可以对日期进行不同风格的格式化。
     */
    @Test
    public void test6() {
        // 获取不同格式化风格和中国环境的日期
        DateFormat df1 = DateFormat.getDateInstance(DateFormat.SHORT, Locale.CHINA);
        DateFormat df2 = DateFormat.getDateInstance(DateFormat.FULL, Locale.CHINA);
        DateFormat df3 = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.CHINA);
        DateFormat df4 = DateFormat.getDateInstance(DateFormat.LONG, Locale.CHINA);

        // 将不同格式化风格的日期格式化为日期字符串
        String date1 = df1.format(new Date());
        String date2 = df2.format(new Date());
        String date3 = df3.format(new Date());
        String date4 = df4.format(new Date());

        // 输出日期
        System.out.println("SHORT：" + date1);
        System.out.println("FULL：" + date2);
        System.out.println("MEDIUM：" + date3);
        System.out.println("LONG：" + date4);

        // 获取不同格式化风格和中国环境的时间
        DateFormat df5 = DateFormat.getTimeInstance(DateFormat.SHORT, Locale.CHINA);
        DateFormat df6 = DateFormat.getTimeInstance(DateFormat.FULL, Locale.CHINA);
        DateFormat df7 = DateFormat.getTimeInstance(DateFormat.MEDIUM, Locale.CHINA);
        DateFormat df8 = DateFormat.getTimeInstance(DateFormat.LONG, Locale.CHINA);

        // 将不同格式化风格的时间格式化为时间字符串
        String time1 = df5.format(new Date());
        String time2 = df6.format(new Date());
        String time3 = df7.format(new Date());
        String time4 = df8.format(new Date());

        // 输出时间
        System.out.println("SHORT：" + time1);
        System.out.println("FULL：" + time2);
        System.out.println("MEDIUM：" + time3);
        System.out.println("LONG：" + time4);
    }

    /*
    * y	年份: 一般用 yy 表示两位年份，yyyy 表示4位年份; eg: yy如 11; yyyy 如2011
    * M	月份。一般用 MM 表示月份，如果使用 MMM，则会根据语言环境显示不同语言的月份; MM如 05；MMM 表示月份，在 Locale.CHINA语言环境下如“十月”；在 Locale.US语言环境下如 Oct
    * d	月份中的天数。一般用 dd 表示天数	使用 dd 表示的天数，如 10
    * E	星期几。用 E 表示，会根据语言环境的不同， 显示不同语言的星期几:在 Locale.CHINA 语言环境下，如“星期四”；在 Locale.US 语言环境下，如 Thu
    * H	一天中的小时数（0~23)。一般用 HH 表示小时数(24小时制)	使用 HH 表示的小时数，如 18
    * h	一天中的小时数（1~12)。一般使用 hh 表示小时数(12小时制)	使用 hh 表示的小时数，如 10 (注意 10 有可能是 10 点，也可能是 22 点）
    * m	分钟数。一般使用 mm 表示分钟数	使用 mm 表示的分钟数，如 29
    * s	秒数。一般使用 ss 表示秒数	使用 ss 表示的秒数，如 38
    * S	毫秒数。一般使用 SSS 表示毫秒数	使用 SSS 表示的毫秒数，如 156
    * */
    @Test
    public void test7(){
        Date now = new Date(); // 创建一个Date对象，获取当前时间
        // 指定格式化格式
        SimpleDateFormat f = new SimpleDateFormat("今天是 " + "yyyy 年 MM 月 dd 日 E HH 点 mm 分 ss 秒");
        SimpleDateFormat f2 = new SimpleDateFormat("今天是 " + "yyyy 年 MM 月 dd 日 E hh 点 mm 分 ss 秒");
        System.out.println(f.format(now)); // 将当前时间袼式化为指定的格式
        System.out.println(f2.format(now));
    }


}

package com.demo.basicdemo;

import org.testng.annotations.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


/**
 * UTC时间是时间标准时间（Universal Time Coordinated），是指零时区的时间，几乎等同于GMT(Greenwich Mean Time)时间
 *
 */
public class DateDemo {


    /**
     * Date是一个和系统时区相关的类，对于CST(China Stand Time)来说
     *
     * 关于时间原点： 是指 GMT/UTC时区 1970-01-01 00:00:00 "那一时刻"对应的时间
     * 对于北京来说，也就是CST时区， "那一时刻"的时间是1970-01-01 08:00:00
     *
     * 时间戳就是从GMT/UTC时区 1970-01-01 00:00:00 "那一时刻" 到现在的经过的millseconds
     * 对于北京来说，也就是CST时区， 是从1970-01-01 08:00:00到当前北京时间所经过的毫秒数
     *
     * 脑海中要有1970-01-01 00:00:00 "这一时刻"或者"那一时刻"的概念
     */
    @Test
    public void test() {

        //Date 类的无参数构造方法获取的是系统当前的时间，显示的顺序为星期、月、日、小时、分、秒、年
        //如果电脑系统是UTC时间，那么new Date()显示的是UTC时间；如果系统是CST时间，那么显示的是CST时间
        Date date1 = new Date();
        System.out.println(date1.toString());


        //timestamp 是指 GMT 1970-01-01 00:00:00 "那一时刻" 起至现在的毫秒数(北京在"那一时刻"的时间是1970-01-01 08:00:00)
        //也就是系统所在时区的“那一时刻”的的时间到系统当前所在时区的时间
        //注意：同一时刻，在全世界任何地点获取的值都是一样的。
        System.out.println(new Date().getTime());
        //等价于
        System.out.println(System.currentTimeMillis());


        //Date(long date)：此种形式表示从GMT 1970年01-01 00:00:00 "那一时刻"系统所在时区的时间(北京在"那一时刻"的时间是1970-01-01 08:00:00)
        //开始经过参数指定的毫秒数之后的系统所在时区的时间。
        System.out.println();
        Date date2 = new Date(3600000);//3600000 ms是一个小时; 对于北京时间CST来说，就是从1970-01-01 08:00:00经过一个小时后的时间
        System.out.println(date2);
        System.out.println(new Date(0));//GMT 1970年01-01 00:00:00 "那一时刻"系统所在时区的时间


        //由上面可知，下面两个日期时间是相同，都代表系统的当前时间
        System.out.println();
        System.out.println(new Date());
        System.out.println(new Date(System.currentTimeMillis()));

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
     *
     *     格式化Date成字符串
     * */
    @Test
    public void test3(){
        Date now = new Date(); // 创建一个Date对象，获取当前时间

        SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd" );// 指定格式化格式
        String time = sdf.format(now);// 将当前时间袼式化为指定的格式
        System.out.println(time);


        SimpleDateFormat sdf1 =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS" );// 指定格式化格式
        String time1 = sdf1.format(now);// 将当前时间袼式化为指定的格式
        System.out.println(time1);// 将当前时间袼式化为指定的格式

        SimpleDateFormat sdf2 =new SimpleDateFormat("yyyy-MM-dd E HH:mm:ss SSS" );// 指定格式化格式
        String time2 = sdf2.format(now);// 将当前时间袼式化为指定的格式
        System.out.println(time2);// 将当前时间袼式化为指定的格式

        SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy 年 MM 月 dd 日 E HH 点 mm 分 ss 秒");// 指定格式化格式
        String time3 = sdf3.format(now);// 将当前时间袼式化为指定的格式
        System.out.println(time3);// 将当前时间袼式化为指定的格式
    }


    /**
     * 模式（yyyy/MM/dd HH:mm:ss）需要和字符串格式保持一致，如果不一样就会抛出解析异常ParseException
     */
    @Test
    public void test4(){

        SimpleDateFormat sdf =new SimpleDateFormat("yyyy/MM/dd HH:mm:ss" );
        String str = "2016/1/5 12:12:12";

        try {
            Date date = sdf.parse(str);
            System.out.println(date);
        } catch (ParseException e) {
            // TODO AutoConvert-generated catch block
            e.printStackTrace();
        }
    }






    /**
     * Calendar 类中定义了许多常量，分别表示不同的意义。
     */
    @Test
    public void test3x() {
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
    public void test4x() {
        Calendar calendar = Calendar.getInstance();
        Date time = calendar.getTime();
        System.out.println(time);

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
    }



}

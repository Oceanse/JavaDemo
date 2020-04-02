package com.demo.enums;
/*不用import java.lang包*/


public interface WeekConstants {

    String MON = "mon";
    String TUE = "tue";
    String WED = "wed";

}

class Cons {
    public static final String MON = "mon";
    public static final String TUE = "tue";
    public static final String WED = "wed";
}

enum WeekEnum{
    MON,
    TUE,
    WED;
}
package com.demo.enums;

public enum MyDay {
    MONDAY(1,"周一"),
    TUESDAY(2,"周二");

    private int code;
    private String name;

    private MyDay(int code,String name){
        this.code = code;
        this.name = name();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "MyDay{" +
                "code=" + code +
                ", name='" + name + '\'' +
                '}';
    }

    public static void main(String[] args) {
        int code = MyDay.MONDAY.getCode();
        String name = MyDay.TUESDAY.getName();
        String name1 = MyDay.TUESDAY.getName();
        int code1 = MyDay.TUESDAY.getCode();
        System.out.println(MyDay.MONDAY);
        System.out.println(MyDay.TUESDAY);
    }
}
